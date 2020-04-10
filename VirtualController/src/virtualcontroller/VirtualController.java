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
 *
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
            while (true) {

                //test robot class
                // Simulate a mouse click
//            robot.mousePress(InputEvent.BUTTON1_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_MASK);
                // Simulate a key press
                // Step 2 : create a DatgramPacket to receive the decodePacket. 
                DpReceive = new DatagramPacket(receive, receive.length);

                // Step 3 : revieve the decodePacket in byte buffer. 
                ds.receive(DpReceive);

                String data = decodePacket(receive).toString();

                System.out.println("Client:-" + data);

                if (data.equals("LEFT")) {
                    virtualRobot.keyPress(KeyEvent.VK_LEFT);
                    virtualRobot.keyRelease(KeyEvent.VK_LEFT);
                } else if (data.equals("RIGHT")) {
                    virtualRobot.keyPress(KeyEvent.VK_RIGHT);
                    virtualRobot.keyRelease(KeyEvent.VK_RIGHT);
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
