import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args[]) {
        try {
            ServerSocket sSocket = new ServerSocket(12345);

            System.out.println("Waiting for client to connect...");
            Socket clientSocket = sSocket.accept();
            System.out.println("Client connected!!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;
            while((message = in.readLine()) != null) {
                System.out.println("Received message from client : " + message);

                out.println("Server received : "  + message);
            }
            in.close();
            out.close();
            clientSocket.close();
            sSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}