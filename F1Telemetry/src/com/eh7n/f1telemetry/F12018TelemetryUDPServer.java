package com.eh7n.f1telemetry;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eh7n.f1telemetry.data.Packet;
import com.eh7n.f1telemetry.data.PacketCarTelemetryData;
import com.eh7n.f1telemetry.data.PacketList;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;
import com.eh7n.f1telemetry.data.elements.PacketType;
import com.eh7n.f1telemetry.util.PacketDeserializer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import udpclient.GPIOThread;

/**
 * The base class for the F1 2018 Telemetry app. Starts up a non-blocking I/O
 * UDP server to read packets from the F1 2018 video game and then hands those
 * packets off to a parallel thread for processing based on the lambda function
 * defined. Leverages a fluent API for initialization.
 *
 * Also exposes a main method for starting up a default server
 *
 * @author eh7n
 *
 */
public class F12018TelemetryUDPServer {

    private static final Logger log = LoggerFactory.getLogger(F12018TelemetryUDPServer.class);

    private static final String USER = "xiexh";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/NewF1DB";

    private static final String DEFAULT_BIND_ADDRESS = "0.0.0.0";
    private static final int DEFAULT_PORT = 20777;
    private static final int MAX_PACKET_SIZE = 1341;

    private String bindAddress;
    private int port;
    private Consumer<Packet> packetConsumer;

    private F12018TelemetryUDPServer() {
        bindAddress = DEFAULT_BIND_ADDRESS;
        port = DEFAULT_PORT;
    }

    /**
     * Create an instance of the UDP server
     *
     * @return
     */
    public static F12018TelemetryUDPServer create() {
        return new F12018TelemetryUDPServer();
    }

    /**
     * Set the bind address
     *
     * @param bindAddress
     * @return the server instance
     */
    public F12018TelemetryUDPServer bindTo(String bindAddress) {
        this.bindAddress = bindAddress;
        return this;
    }

    /**
     * Set the bind port
     *
     * @param port
     * @return the server instance
     */
    public F12018TelemetryUDPServer onPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Set the consumer via a lambda function
     *
     * @param consumer
     * @return the server instance
     */
    public F12018TelemetryUDPServer consumeWith(Consumer<Packet> consumer) {
        packetConsumer = consumer;
        return this;
    }

    /**
     * Start the F1 2018 Telemetry UDP server
     *
     * @throws IOException if the server fails to start
     * @throws IllegalStateException if you do not define how the packets should
     * be consumed
     */
    public void start() throws IOException {

        if (packetConsumer == null) {
            throw new IllegalStateException("You must define how the packets will be consumed.");
        }

        log.info("F1 2018 - Telemetry UDP Server");

        // Create an executor to process the Packets in a separate thread
        // To be honest, this is probably an over-optimization due to the use of NIO,
        // but it was done to provide a simple way of providing back pressure on the
        // incoming UDP packet handling to allow for long-running processing of the
        // Packet object, if required.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        

        try (DatagramChannel channel = DatagramChannel.open()) {
            channel.socket().bind(new InetSocketAddress(bindAddress, port));
            log.info("Listening on " + bindAddress + ":" + port + "...");
            ByteBuffer buf = ByteBuffer.allocate(MAX_PACKET_SIZE);
            buf.order(ByteOrder.LITTLE_ENDIAN);

//            GPIOThread gpioThread = new GPIOThread();
//            gpioThread.start();
            
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Settings settings = new Settings().withExecuteLogging(true); // turn off debug log output
            DSLContext dbContext = DSL.using(conn, SQLDialect.MYSQL, settings);
            Result<DatanamesRecord> names = dbContext.selectFrom(ndbconn.Tables.DATANAMES).fetch();
            HashMap<String, Short> nameIdMap = listToMap(names);

            // create and initialize history packets
            @SuppressWarnings("MismatchedReadAndWriteOfArray")
            PacketList[] histPacketLists = new PacketList[PacketType.values().length];
            for (int i = 0; i < PacketType.values().length; i++) {
                histPacketLists[i] = new PacketList();
            }

            while (true) {
                channel.receive(buf);
                final Packet packet = PacketDeserializer.read(buf.array());
//                                System.out.println(packet.toJSON());        // same effect as placed in consumedWith();
                histPacketLists = packet.saveToDB(histPacketLists, dbContext); // the executor may use multithread to consume packet, but in my Raspeberry pi, there is only
                
                // update output data to PIC
                if(packet instanceof PacketCarTelemetryData){
                    CarTelemetryData tData = ((PacketCarTelemetryData) packet).
                            getCarTelemetryData().get(packet.getHeader().getPlayerCarIndex());
//                    gpioThread.setSpeed(tData.getSpeed());
//                    gpioThread.updateBlinkPeriod();
//                    if(tData.getGear()==-1){
//                        gpioThread.setForwardStatus(false);
//                    }
//                    else{
//                        gpioThread.setForwardStatus(true);
//                    }
                }
                        // one thread, so there is no need to use multithread to handle packets
                        //                                executor.submit(() -> {
                        //					packetConsumer.accept(packet);
                        ////                                        System.out.println(packet.toJSON());
                        //				});
                buf.clear();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(F12018TelemetryUDPServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
    }
    
    /**
     * convert a list of name record into a hash map-->>improve search efficiency
     * @param dNameList
     * @return 
     */
    public HashMap<String, Short> listToMap(Result<DatanamesRecord> records)
    {
        HashMap<String, Short> recordMap = new HashMap<>(records.size());
        for(DatanamesRecord r:records){
            recordMap.put(r.getName(), r.getIdname());
        }
        return recordMap;
    }

    /**
     * Main class in case you want to run the server independently. Uses
     * defaults for bind address and port, and just logs the incoming packets as
     * a JSON object to the location defined in the logback config
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//            Thread gpioThread = new GPIOThread();
//            gpioThread.start();
        F12018TelemetryUDPServer.create()
                .bindTo("0.0.0.0")
                .onPort(20777)
                .consumeWith((p) -> {
//                                                                System.out.println(p.toJSON());

                })
                .start();
    }
}
