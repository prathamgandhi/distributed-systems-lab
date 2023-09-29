import java.io.*;
import java.net.*;

public class TcpServer {
	public static void main(String[] args) throws Exception	{
		ServerSocket ss=new ServerSocket(8088);
		System.out.println("Server is ready!");
		try{
			while(true){
				Socket ls=ss.accept();
				System.out.println("Clinet Port is : " + ls.getPort());
				try{
					DataInputStream is= new DataInputStream(ls.getInputStream());
					DataOutputStream os = new DataOutputStream(ls.getOutputStream());
					String clientMessage = is.readUTF();
					System.out.println("Client Message : " + clientMessage);;
					os.writeUTF("Hello " + clientMessage);
					os.flush();
				}
				finally{
					ls.close();
				}
			}
		}
		finally {
			ss.close();
		}
	}
}