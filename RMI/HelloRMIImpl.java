
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRMIImpl extends UnicastRemoteObject implements HelloRMI{

    protected HelloRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from the server";
    }
     
}
