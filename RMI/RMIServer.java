import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            HelloRMI remoteObj = new HelloRMIImpl();

            Registry registry = LocateRegistry.createRegistry(12345);
            
            registry.bind("HelloRMI", remoteObj);

            System.out.println("Server is ready to serve");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
