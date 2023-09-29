import java.net.*;
class UDPServer{
	public static void 	main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(8088);
		System.out.println("Server ready :");
		try{
			while(true){
				byte buff[]=new byte[1024];
				DatagramPacket p = new DatagramPacket(buff,buff.length);
				ds.receive(p);
				String msg = new String( p.getData(),0,p.getLength()).trim();
				String str = "Hello "+new String(buff);
				buff = str.getBytes();
				ds.send(new DatagramPacket(buff,buff.length,InetAddress.getLocalHost(),8089));
				System.out.println("Msg received "+msg);
			}
		}
		finally{
			ds.close();
		}
	}
}
