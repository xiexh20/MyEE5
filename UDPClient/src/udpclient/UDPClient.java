

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

/**
 * UDP client running at Raspberry pi. Main tasks:
 * 1. Read data from micro controller via I2C communication
 * 2. Translate sensor data and send to PC via UDP packet
 * 3. Receive UDP packet from F1 simulator, translate and display in dashboard
 * 4. Extract useful information from Telemetry UDP packet and save into MySQL database
 * 
 * @author 25691
 */
public class UDPClient {
    
    // constant for UDP client configuration
    static final String SERVER_IP = "192.168.1.10";
    static final int SERVER_PORT = 5200;

    private static final byte PICADDR = 0x18;       // address of the PIC
    private static final int FRAME_LEN = 10;      // the length of a frame
    
    

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
        System.out.println("Server socket: "+ip.toString()+":"+address.getPort());
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
        int [] recv_last = new int[FRAME_LEN];
        
        while(true){
            
            // read a frame of data from microcontroller
            int [] recv_buf = new int[FRAME_LEN];
            for(int i=0;i<FRAME_LEN;i++){
                recv_buf[i] = device.read();
            }
            console.println("ADC result=" + String.format("0x%02x", recv_buf[0]));

            // translate the data into keyboard command 
            String command = null;
            if(recv_buf[0]>150){    
                command = "PRESS_LEFT";
            }
            else if(recv_buf[0]<100){
                command = "PRESS_RIGHT";
            }
            else{
                command = "RELEASE";
            }
            
            
            // send UDP packet
            buf = command.getBytes();
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, SERVER_PORT); 
            ds.send(DpSend); 
//            System.out.println("UDP Data sent: "+command);
            
            
            recv_last = recv_buf;
            Thread.sleep(1);
          
        }
    }
    

    public UDPClient() {
    }
    
}
