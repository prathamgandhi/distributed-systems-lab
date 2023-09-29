
//Client program
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class AddClient {
    private AddClient() {};
    public static void main(String arges[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first parameter");
        int a = sc.nextInt();
        System.out.println("Enter second parameter");
        int b = sc.nextInt();
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            AddRem stub = (AddRem) registry.lookup("Add");
            System.out.println(stub.addNum(a, b));
        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (NotBoundException nbe) {
            nbe.printStackTrace();
        }
        sc.close();
    }
}