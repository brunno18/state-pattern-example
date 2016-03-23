package tcp;

public class TCPClient {
	public static void main( String[] args )
	{
		TCPConnection connection = new TCPConnection();
		connection.passiveOpen();
		connection.send();
		connection.close();
	}
}
