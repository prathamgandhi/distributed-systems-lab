import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);

            while(true) {
                Socket clientSocket = ss.accept();

                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                sendTime(clientSocket);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
    }    

    public static void sendTime(Socket clientSocket) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = dateFormat.format(new Date());
            System.out.println("Sending time " + dateTime);
            out.print("hello " + dateTime);
            out.flush();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
