/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;
// Java program to illustrate Client side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.InetSocketAddress;
import java.util.Scanner;
/**
 *
 * @author 25691
 */
public class UDPClient {
    
    static final String SERVER_IP = "192.168.1.10";
    static final int SERVER_PORT = 5200;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
       
        
        Scanner sc = new Scanner(System.in); 
  
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetSocketAddress address = new InetSocketAddress(SERVER_IP, SERVER_PORT);
        
//        InetAddress ip = InetAddress.getLocalHost(); 
        InetAddress ip = address.getAddress();

        System.out.println("Server socket: "+ip.toString()+":"+address.getPort());
        byte buf[] = null; 
  
        // loop while user not enters "bye" 
        int count = 0;
        String[] commands = {"LEFT", "RIGHT"};
        while (true) 
        { 
            
            String inp = commands[count%2]; 
            count++;
            
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, SERVER_PORT); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
            System.out.println("Data sent: "+inp);
            Thread.sleep(1000);
  
            // break the loop if user enters "bye" 
            if (inp.equals("bye")) 
                break; 
        }
    }

    public UDPClient() {
    }
    
}
