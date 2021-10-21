
package udp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;



public class UDPClient {
    public static void main(String[] args) throws Exception{
        
        while(true){
            System.out.println("Ingrese 'NO' para cerrar sesión o escriba 'SI' para mandar mesnajes");
            BufferedReader opcion = new BufferedReader(new InputStreamReader(System.in));
            String opcion_entrada= opcion.readLine();
            if(opcion_entrada.equals("NO")){
                break;
            }
            System.out.println("Ingrese el mensaje");
            BufferedReader InFromUser = new BufferedReader(new InputStreamReader(System.in));
           DatagramSocket clientSocket = new DatagramSocket();
         InetAddress IPAdress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence = InFromUser.readLine();
             sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 9876);
            clientSocket.send(sendPacket);
            DatagramPacket recivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(recivePacket);
            String modifiedSentence = new String(recivePacket.getData());
            System.out.println("FROM SERVER: "+modifiedSentence);
            clientSocket.close();
            
            
        }
        
        
    }
}