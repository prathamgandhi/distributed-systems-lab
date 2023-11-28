import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            String message = "echo";

            byte buffer[] = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            
            ds.send(packet);

            byte receiveBuffer[] = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            ds.receive(receivePacket);
            System.out.println(new String(receivePacket.getData(), 0, receivePacket.getLength()));
            ds.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
