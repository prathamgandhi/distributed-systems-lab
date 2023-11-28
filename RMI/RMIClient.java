import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry regsitry = LocateRegistry.getRegistry("localhost", 12345);

            HelloRMI remoteObject = (HelloRMI) regsitry.lookup("HelloRMI");

            String result = remoteObject.sayHello();
            System.out.println("Server says : " + result);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    } 
}
