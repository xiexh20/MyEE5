/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

import java.io.IOException;
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

// UDP communication imports
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * the Thread to run pi4j related control: 1. receive data from micro controller
 * 2. send data to micro controller 3. send UDP packet to PC
 *
 * @author 25691
 */
public class GPIOThread extends Thread {

    // raw data from Telemetry Packet
    private boolean isForward;  // driving status, is driving forward or backward
    private int speed;      // speed of the car

    private int blinkPeriod;    // the LED blinking period

    private static final int MAXSPEED = 300;
    private static final int MINSPEED = 0;
    private static final int MAXPERIOD = 255;
    private static final int MINPERIOD = 15;

    // some constant cccccccccccccc
    // constant for UDP client configuration
    static final String SERVER_IP = "192.168.1.4";
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

    public GPIOThread() {
        isForward = true;       // by default, set to forward
        speed = 0;      // default speed is zero
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setForwardStatus(boolean isForward) {
        this.isForward = isForward;
    }

    public boolean isForward() {
        return isForward;
    }

    /**
     * use speed to calculate blink period max speed: 300 km/h --blink period =
     * 15 min speed: 0 km/h -- blink period = 255
     */
    public void updateBlinkPeriod() {
        blinkPeriod = (int) (MAXPERIOD - 1.0 * (MAXPERIOD - MINPERIOD) * speed / (MAXSPEED - MINSPEED));
    }

    public int getBlinkPeriod() {
        return blinkPeriod;
    }

    @Override
    public void run() {
        try {
            // TODO: implement calculation to update blinkPeriod
            // TODO: exception handler
            // UDP client setup
            DatagramSocket ds = new DatagramSocket();
            InetSocketAddress address = new InetSocketAddress(SERVER_IP, SERVER_PORT);
            InetAddress ip = address.getAddress();
            System.out.println("Server socket: " + ip.toString() + ":" + address.getPort());

            // create Pi4J console wrapper/helper
            // (This is a utility class to abstract some of the boilerplate code)
            final Console console = new Console();
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
//                    console.println("Unsupported I2C bus " + number + " required");
                }
            }

            // get the I2C bus to communicate on
            I2CBus i2c = null;
            try {
                i2c = I2CFactory.getInstance(I2CBus.BUS_1);

            } catch (I2CFactory.UnsupportedBusNumberException ex) {
                Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            I2CDevice device = null;
            try {
                device = i2c.getDevice(PICADDR);
            } catch (IOException ex) {
                Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            int[] recvBuf = new int[FRAME_LEN];
            byte[] sendBuf = new byte[FRAME_LEN];
            sendBuf[SPEEDidx] = 0b00001010;
            sendBuf[BACKidx] = 0b00000001;
            sendBuf[2] = 0b00000001;

            int count = 0;
            while (true) {
                // read a frame of data from microcontroller
//                console.println("##################");
                for (int i = 0; i < FRAME_LEN; i++) {
                    try {
                        recvBuf[i] = device.read();
                    } catch (IOException ex) {
                        Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // prepare data to be sent
                sendBuf[0] = (byte) blinkPeriod;
                if (isForward) {
                    sendBuf[BACKidx] = 0;
                } else {
                    sendBuf[BACKidx] = 1;
                }
                sendBuf[2] = 0;

//             send a frame data
                for (int i = 0; i < FRAME_LEN; i++) {
                    try {
                        device.write(sendBuf[i]);
                    } catch (IOException ex) {
                        Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                try {
                    // send UDP packet
                    String UDPData = "ADRSH:" + recvBuf[0] + ":" + "PORTA:" + recvBuf[1] + ":" + "PORTB:" + recvBuf[2] + ":";
                    byte[] buf = UDPData.getBytes();
                    DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, SERVER_PORT);
                    ds.send(DpSend);
//                    System.out.println("UDP Data sent: " + UDPData);
                    Thread.sleep(5);        // poll frequency: 200Hz
                } catch (InterruptedException ex) {
                    Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {            
                    Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SocketException ex) {
            Logger.getLogger(GPIOThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
