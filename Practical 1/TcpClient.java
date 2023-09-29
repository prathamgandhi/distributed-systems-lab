import java.net.*;
import java.io.*;

class TcpClient {
	public static void main(String[] args) throws Exception	{
		System.out.println("connecting to server");
		Socket cs=new Socket("localhost",8088);
		
		BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
		DataInputStream is = new DataInputStream(cs.getInputStream());
		DataOutputStream os = new DataOutputStream(cs.getOutputStream());
		System.out.println("The Local Port "+cs.getLocalPort()+"\nThe Remote Port "+cs.getPort());
		System.out.println("The Local socket is "+cs);
		System.out.println("Enter your name : ");
		String str=br.readLine();
		//SENDING DATA TO SERVER
		os.writeUTF(str);
		//READING DATA FROM SERVER
		String serverReply = is.readUTF();
		//PRINTING MESSAGE ON CLIENT CONSLOE
		serverReply = serverReply.trim();
		System.out.println("Server Replied : " + serverReply);
		cs.close();
	}
}
