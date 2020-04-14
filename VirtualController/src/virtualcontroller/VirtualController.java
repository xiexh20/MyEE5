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
            while (true) {

                DpReceive = new DatagramPacket(receive, receive.length);

                // Step 3 : revieve the decodePacket in byte buffer. 
                ds.receive(DpReceive);

                String data = decodePacket(receive).toString();

//                System.out.println("Client:-" + data);
                
                // TODO: optimize the simulation algorithm
                if (data.equals("PRESS_LEFT")) {
//                    virtualRobot.keyPress(KeyEvent.VK_LEFT);
//                    if(leftPressed==false){
                        virtualRobot.keyPress(KeyEvent.VK_LEFT);
                        System.out.println("LEFT pressed");
                        leftPressed = true;
//                    }
                    
                    
                    
//                    virtualRobot.keyRelease(KeyEvent.VK_LEFT);
                }
                else if(data.equals("RELEASE")){
                    if(leftPressed){
                        virtualRobot.keyRelease(KeyEvent.VK_LEFT);
                        leftPressed = false;
                        System.out.println("release LEFT");
                    }
                    
                    if(rightPressed){
                         virtualRobot.keyRelease(KeyEvent.VK_RIGHT);
                         rightPressed = false;
                         System.out.println("release RIGHT");
                    }
                        
                    
                }
                else if (data.equals("PRESS_RIGHT")) {
                    virtualRobot.keyPress(KeyEvent.VK_RIGHT);
//                    if(rightPressed==false){
//                        virtualRobot.keyPress(KeyEvent.VK_RIGHT);
                        System.out.println("RIGHT pressed");
                        rightPressed = true;
//                    }
                    
                            

                }
                

                // Exit the server if the client sends "bye" 
                if (decodePacket(receive).toString().equals("bye")) {
                    System.out.println("Client sent bye.....EXITING");
                    break;
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
