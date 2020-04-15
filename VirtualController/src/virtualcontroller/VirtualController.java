/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcontroller;

// Java program to illustrate Server side 
// Implementation using DatagramSocket 
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * virtual controller running at PC. Main tasks:
 * 1. Decode UDP packet from Pi
 * 2. Simulate key press/release based on received UDP packet. Software optimization is very important to reduce latency
 * and improve user experience 
 * @author 25691
 */
public class VirtualController {

    static final String LOCAL_IP = "192.168.1.10";
    static final int LOCAL_PORT = 5200;
    static final int ADCidx = 1;
    static final int PORTAidx = 3;
    static final char BITF = 0x80;
    static final char BIT1 = 0x02;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        // TODO code application logic here
        // Step 1 : Create a socket to listen at port 1234 
//        DatagramSocket ds; 
        Robot virtualRobot = new Robot();
        try {
//            ds = new DatagramSocket(1234);
            byte[] receive = new byte[65535];

            DatagramSocket ds = new DatagramSocket(null);
            InetSocketAddress address = new InetSocketAddress(LOCAL_IP, LOCAL_PORT);

            ds.bind(address);

            DatagramPacket DpReceive = null;
            boolean leftPressed = false;    // left key pressed or not
            boolean rightPressed = false;   // right key pressed or not
            boolean spacePressed = false;   
            boolean ctrlPressed = false;
            while (true) {

                DpReceive = new DatagramPacket(receive, receive.length);

                // Step 3 : revieve the decodePacket in byte buffer. 
                ds.receive(DpReceive);
                
                // release all buttons;
                virtualRobot.keyRelease(KeyEvent.VK_LEFT);
                virtualRobot.keyRelease(KeyEvent.VK_RIGHT);
                virtualRobot.keyRelease(KeyEvent.VK_CONTROL);                                                                                                                                                                                                                                                                                                                           
                virtualRobot.keyRelease(KeyEvent.VK_SPACE);
                

                String data = decodePacket(receive).toString();

//                System.out.prin                                                                                  tln("Client:-" + data);
                // extract data from the string
                String [] strSlices = data.split(":");
                int ADCresult = Integer.parseInt(strSlices[ADCidx]);
                int portA = Integer.parseInt(strSlices[PORTAidx]);
                
                
                System.out.println("ADC="+ADCresult+" PORTA="+portA);
                
                if(ADCresult<110){
                    virtualRobot.keyPress(KeyEvent.VK_LEFT);
                    leftPressed = true;
                }
                else if(ADCresult>134){
                    virtualRobot.keyPress(KeyEvent.VK_RIGHT);
                    rightPressed = true;
                
                }
                else{
                    if(leftPressed){
                        virtualRobot.keyRelease(KeyEvent.VK_LEFT);
                        leftPressed = false;
                    }
                    
                    if(rightPressed){
                        virtualRobot.keyRelease(KeyEvent.VK_RIGHT);
                        rightPressed = false;
                    }
                }
                
                if((portA&BITF)==BITF){
                    // speed up
                    virtualRobot.keyPress(KeyEvent.VK_SPACE);
                    spacePressed = true;
                }
                else{
                    if(spacePressed){
                        virtualRobot.keyRelease(KeyEvent.VK_SPACE);
                        spacePressed = false;
                    }
                }
                
                if((portA&BIT1)==BIT1){
                    virtualRobot.keyPress(KeyEvent.VK_CONTROL);
                    ctrlPressed = true;
                }
                else{
                    if(ctrlPressed){
                        virtualRobot.keyRelease(KeyEvent.VK_CONTROL);
                        ctrlPressed = false;
                    }
                }
                
                

                

                // Clear the buffer after every message. 
                receive = new byte[65535];
            }
        } catch (SocketException ex) {
            Logger.getLogger(VirtualController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // A utility method to convert the byte array 
    // decodePacket into a string representation. 
    public static StringBuilder decodePacket(byte[] a) {
        if (a == null) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }

}
