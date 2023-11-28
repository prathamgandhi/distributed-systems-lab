import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Echo");
            
            String response = in.readLine();
            System.out.println("Server Received : " + response); 
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
