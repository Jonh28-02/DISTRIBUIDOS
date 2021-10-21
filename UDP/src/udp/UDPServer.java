
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;
import java.net.*;
/**
 *
 * @author inspiron
 */
public class UDPServer {
    public static void main(String args[]) throws Exception{
        DatagramSocket serverSocket=new DatagramSocket(9876);
        
        while(true)
        {
            byte[] receiveData=new byte[1024];
        byte [] sendData=new byte[1024];
            DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence=new String (receivePacket.getData());
            System.out.println("RECEIVED: "+sentence);
            InetAddress IPAddress=receivePacket.getAddress();
            int port=receivePacket.getPort();
            String capitalizedSentence=sentence.toUpperCase();
            sendData=capitalizedSentence.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,port);
            serverSocket.send(sendPacket);
        }
    }
    
    
    
    
}
