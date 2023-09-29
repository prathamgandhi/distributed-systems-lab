
//server program
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AddServer extends AddRemImpl{
    public AddServer() {}
    public static void main(String args[]) {
        try {
            AddRemImpl locobj = new AddRemImpl();
            AddRem stub = (AddRem) UnicastRemoteObject.exportObject(locobj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Add", stub);
            System.err.println("Server Ready...");
        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (AlreadyBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}