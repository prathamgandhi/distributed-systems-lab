import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try{
            DatagramSocket ds = new DatagramSocket(12345);

            byte buffer[] = new byte[1024];

            DatagramPacket packet = new DatagramPacket(buffer, 1024);

            System.out.println("Waiting for client to send data...");

            ds.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server received : " + message);
            ds.send(new DatagramPacket(packet.getData(), packet.getLength(), packet.getAddress(), packet.getPort()));
            ds.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }    
}
