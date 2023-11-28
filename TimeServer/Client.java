import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 12345);

            BufferedReader in  = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String message = in.readLine();

            System.out.println("Time received is : " + message);
            in.close();
            s.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    } 
}
