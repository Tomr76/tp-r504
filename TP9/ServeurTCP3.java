import java.io.*;
import java.net.*;

public class ServeurTCP3
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket socketserver = new ServerSocket(2016);
			System.out.println("Serveur en attente...");

			while (true)
			{
				Socket socket = socketserver.accept();
				System.out.println("Connexion d'un client");

				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				String receivedMessage = dIn.readUTF();

				String reversedMessage = new StringBuilder(receivedMessage).reverse().toString();

				DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
				dOut.writeUTF(reversedMessage);

				dIn.close();
				dOut.close();
				socket.close();
			}
		}
		catch (Exception ex)
		{
			System.out.println("Erreur !");
			ex.printStackTrace();
		}
	}
}
