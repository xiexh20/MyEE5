package udpclient;
// Implementation using DatagramSocket 

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;

// pi4j imports
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.util.Console;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UDP client running at Raspberry pi. Main tasks: 1. Read data from micro
 * controller via I2C communication 2. Translate sensor data and send to PC via
 * UDP packet 3. Receive UDP packet from F1 simulator, translate and display in
 * dashboard 4. Extract useful information from Telemetry UDP packet and save
 * into MySQL database
 *
 * @author 25691
 */
public class UDPClient {

    // constant for UDP client configuration
    static final String SERVER_IP = "192.168.1.10";
    static final int SERVER_PORT = 5200;

    private static final byte PICADDR = 0x18;       // address of the PIC
    private static final int FRAME_LEN = 3;      // the length of a frame
    
    // index definition for received data
    private static final int ADCRESHidx = 0;
    private static final int PORTAidx = 1;
    private static final int PORTBidx = 2;
    
    // index definition for data to be transmitted
    private static final int SPEEDidx = 0;
    private static final int BACKidx = 1;   // back light
    
    // bit definition for different input buttons
    private static final char BITctrl = 0x80;   // RB7 is ctrl pin
    private static final char BIT120 = 0x40;     // RB6, button with an emergency car, undefined function
    
    private static final char BITtruck = 0x04;        // RA2, button with a truck pattern, undefined function
    private static final char BITear = 0x08;        //RA3, button with an ear pattern, undefined function
    private static final char BITgreen = 0x10;      // RA4, unstable input, button with G
    private static final char BITyellow = 0x20;     // RA5, button with Y
    private static final char BITred = 0x80;        // RA7, button with R
    private static final char BITSPACE = 0x40;        // RA6, space button function
    
    

    /**
     * Program Main Entry Point
     *
     * @param args
     * @throws InterruptedException
     * @throws PlatformAlreadyAssignedException
     * @throws IOException
     * @throws I2CFactory.UnsupportedBusNumberException
     */
    public static void main(String[] args) throws InterruptedException, PlatformAlreadyAssignedException, IOException, I2CFactory.UnsupportedBusNumberException {

        // TODO: exception handler
        // UDP client setup
        DatagramSocket ds = new DatagramSocket();
        InetSocketAddress address = new InetSocketAddress(SERVER_IP, SERVER_PORT);
        InetAddress ip = address.getAddress();
        System.out.println("Server socket: " + ip.toString() + ":" + address.getPort());
        byte buf[] = null;

        // create Pi4J console wrapper/helper
        // (This is a utility class to abstract some of the boilerplate code)
        final Console console = new Console();

        // print program title/header
        console.title("<-- The Pi4J Project -->", "I2C Example");

        // allow for user to exit program using CTRL-C
        console.promptForExit();

        // fetch all available busses
        try {
            int[] ids = I2CFactory.getBusIds();
            console.println("Found follow I2C busses: " + Arrays.toString(ids));
        } catch (IOException exception) {
            console.println("I/O error during fetch of I2C busses occurred");
        }

        // find available busses
        for (int number = I2CBus.BUS_0; number <= I2CBus.BUS_17; ++number) {
            try {
                @SuppressWarnings("unused")
                I2CBus bus = I2CFactory.getInstance(number);
                console.println("Supported I2C bus " + number + " found");

            } catch (IOException exception) {
                console.println("I/O error on I2C bus " + number + " occurred");
            } catch (I2CFactory.UnsupportedBusNumberException exception) {
                console.println("Unsupported I2C bus " + number + " required");
            }
        }

        // get the I2C bus to communicate on
        I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

        // create an I2C device for an individual device on the bus that you want to communicate with
        I2CDevice device = i2c.getDevice(PICADDR);

        int[] recvBuf = new int[FRAME_LEN];
        byte[] sendBuf = new byte[FRAME_LEN];
        sendBuf[0] = 0b00001010;
        sendBuf[1] = 0b00000001;
        sendBuf[2] = 0b00000001;
        
        int count = 0;
        while (true) {
            
            

            // read a frame of data from microcontroller
            console.println("##################");
            for(int i=0;i<FRAME_LEN;i++){
                recvBuf[i] = device.read();
            }
            console.println("ADC result=" + String.format("0x%02x", recvBuf[0]));
            // print binary code
            console.println("PORTA=" + String.format("%8s", Integer.toBinaryString(recvBuf[1] & 0xFF)).replace(' ', '0'));
            
            console.println("PORTB=" + String.format("%8s", Integer.toBinaryString(recvBuf[2] & 0xFF)).replace(' ', '0'));
            

//            if((recvBuf[1]&0x80)==0){
//                sendBuf[1] = 0b00000000;;
//            }
//            else{
//                sendBuf[1] = 0b00000001;;
//            }

            // prepare data to be sent
            count ++;
            if(count == 50){
                count = 0;
                sendBuf[SPEEDidx]--;
                if(sendBuf[SPEEDidx]==1){
                    sendBuf[SPEEDidx] = 20;
                }
            }
            if((recvBuf[PORTBidx]&BITctrl)==BITctrl){
                sendBuf[BACKidx] = 1;
            }
            else{
                sendBuf[BACKidx] = 0;
            }
            
            
//             send a frame data
            for(int i = 0;i<FRAME_LEN; i++){
                device.write(sendBuf[i]);
                
            }
            console.println("-----------------");
            console.println("T0Thres=" + sendBuf[0]);
            console.println("Back LED=" + sendBuf[1]);
//            console.println("LED2=" + sendBuf[2]);
            
            
            
//            for(int i=0;i<FRAME_LEN;i++){
//                recvBuf[i] = device.read();
//            }
//            console.println("ADC result=" + String.format("0x%02x", recvBuf[0]));
//            console.println("PORTA=" + String.format("0x%02x", recvBuf[1]));
            
            // send UDP packet
//            buf = command.getBytes();
//            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, SERVER_PORT); 
//            ds.send(DpSend); 
//            System.out.println("UDP Data sent: "+command);
//            String UDPData = "ADRSH:"+recvBuf[0]+":"+"PORTA:"+recvBuf[1]+":";
//            buf = UDPData.getBytes();
//            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, SERVER_PORT); 
//            ds.send(DpSend); 
//            System.out.println("UDP Data sent: "+UDPData);
            Thread.sleep(100);
            
//          
        }
    }

    public UDPClient() {
    }

}
