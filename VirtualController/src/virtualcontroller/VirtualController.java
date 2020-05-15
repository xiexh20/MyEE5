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
 * virtual controller running at PC. Main tasks: 1. Decode UDP packet from Pi 2.
 * Simulate key press/release based on received UDP packet. Software
 * optimization is very important to reduce latency and improve user experience
 *
 * @author 25691
 */
public class VirtualController {

    static final String LOCAL_IP = "192.168.1.4";
    static final int LOCAL_PORT = 5200;
    // index in the sliced string array
    static final int ADCidx = 1;
    static final int PORTAidx = 3;
    private static final int PORTBidx = 5;

    // bit definition for different input buttons
    private static final char BITctrl = 0x80;   // RB7 is ctrl pin
    private static final char BITESC = 0x40;     // RB6, button with an emergency car, undefined function

    private static final char BITtruck = 0x04;        // RA2, button with a truck pattern, undefined function
    private static final char BITC = 0x08;        //RA3, button with an ear pattern, undefined function
    private static final char BITgreen = 0x10;      // RA4, unstable input, button with G
    private static final char BITW = 0x20;    // RA5, button with Y--W, activate DRS
    private static final char BITred = 0x80;        // RA7, button with R
    private static final char BITSPACE = 0x40;        // RA6, space button function
    
    private static final int UNLOCK = 50;  // unlock period, set to 1 second

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        // TODO code application logic here
        // Step 1 : Create a socket to listen at port 1234 
        Robot virtualRobot = new Robot();
        try {
            byte[] receive = new byte[65535];

            DatagramSocket ds = new DatagramSocket(null);
            InetSocketAddress address = new InetSocketAddress(LOCAL_IP, LOCAL_PORT);

            ds.bind(address);

            DatagramPacket DpReceive = null;
            boolean leftPressed = false;    // left key pressed or not
            boolean rightPressed = false;   // right key pressed or not
            boolean spacePressed = false;
            boolean ctrlPressed = false;
            boolean CPressed = false;
            boolean ESCPressed = false;
            boolean WPressed = false;
                    
            int ClockCount = 0;
            int WlockCount = 0;
            int ESClockCount = 0;   // lock counter for some buttons
            
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

                // extract data from the string
                String[] strSlices = data.split(":");
                int ADCresult = Integer.parseInt(strSlices[ADCidx]);
                int portA = Integer.parseInt(strSlices[PORTAidx]);
                int portB = Integer.parseInt(strSlices[PORTBidx]);

                System.out.println("ADC=" + ADCresult + " PORTA=" + portA);

                if (ADCresult < 110) {
                    virtualRobot.keyPress(KeyEvent.VK_LEFT);
                    leftPressed = true;
                } else if (ADCresult > 134) {
                    virtualRobot.keyPress(KeyEvent.VK_RIGHT);
                    rightPressed = true;

                } else {
                    if (leftPressed) {
                        virtualRobot.keyRelease(KeyEvent.VK_LEFT);
                        leftPressed = false;
                    }

                    if (rightPressed) {
                        virtualRobot.keyRelease(KeyEvent.VK_RIGHT);
                        rightPressed = false;
                    }
                }
                
                
                // space button
                if ((portA & BITSPACE) == BITSPACE) {
                    // speed up
                    virtualRobot.keyPress(KeyEvent.VK_SPACE);
                    spacePressed = true;
                    
                    // unlock ESC, W, C button
                    ESCPressed = false;
                    WPressed = false;
                    CPressed = false;
                } else {
                    if (spacePressed) {
                        virtualRobot.keyRelease(KeyEvent.VK_SPACE);
                        spacePressed = false;
                    }
                }
                
                // ctrl button
                if ((portB & BITctrl) == BITctrl) {
                    virtualRobot.keyPress(KeyEvent.VK_CONTROL);
                    ctrlPressed = true;
                } else {
                    if (ctrlPressed) {
                        virtualRobot.keyRelease(KeyEvent.VK_CONTROL);
                        ctrlPressed = false;
                    }
                }
                
                // ESC button
                if((portB&BITESC)==BITESC && ESCPressed==false){
                    virtualRobot.keyPress(KeyEvent.VK_ESCAPE);
                    Thread.sleep(10);
                    ESCPressed = true;
                    virtualRobot.keyRelease(KeyEvent.VK_ESCAPE);
                }
                if(ESCPressed){
                    ESClockCount++;
                    if(ESClockCount==UNLOCK){
                        ESCPressed=false;
                        ESClockCount = 0;
                    }
                }
                
                // key C
                if((portA&BITC)==BITC&&CPressed==false){
                    virtualRobot.keyPress(KeyEvent.VK_C);
                    Thread.sleep(10);
                    CPressed = true;
                    virtualRobot.keyRelease(KeyEvent.VK_C);
                }
                if(CPressed){
                    ClockCount++;
                    if(ClockCount==UNLOCK){
                        ClockCount=0;
                        CPressed = false;   // unlock
                    }
                }
                
                // Key W
                if((portA&BITW)==BITW&&WPressed==false){
                    virtualRobot.keyPress(KeyEvent.VK_W);
                    Thread.sleep(10);
                    WPressed = true;
                    virtualRobot.keyRelease(KeyEvent.VK_W);
                }
                if(WPressed){
                    WlockCount++;
                    if(WlockCount==UNLOCK){
                        WlockCount=0;
                        WPressed=false;
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
