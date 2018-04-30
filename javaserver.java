import java.io.*;
import java.net.*;
import java.util.*;

public class javaserver{

  public static void main (String [] args){

	
	try{  		
		
	//Create a server socket
  	ServerSocket MyServer = new ServerSocket(36846);  
	 	System.out.println("\n[+] Socket Opened\n"); 

		//Accept connection
		Socket socket = MyServer.accept();
		System.out.println("\n[+] Accept Opened\n");	

	//Declaration of recveive & send msg
	String recv_msg, send_msg;		
	//Input Stream 
	DataInputStream input = new DataInputStream(socket.getInputStream());
	//Output Stream to Client
	DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
	//BufferedReader From Client
	BufferedReader fromUser = new BufferedReader(new 			InputStreamReader(socket.getInputStream()));
	

	while(true){

		//Receive message From client
		recv_msg = fromUser.readLine();
		System.out.println("\nMessage received: " + recv_msg);
	
		//Send tell what client want
		send_msg = "\nPlease enter your request: \n";
		outToClient.writeBytes(send_msg);
		outToClient.flush();
	
		//Receive client request
		recv_msg = fromUser.readLine();
		if(recv_msg.equalsIgnoreCase("IP"))
		{
			//Send IP address
			String clientAddress =  socket.getInetAddress().getHostAddress();
			outToClient.writeBytes(clientAddress);
			outToClient.flush();
		}
		else
		{
			//Terminate 
			System.exit(1);
		}
		//Close socket
		socket.close();
		MyServer.close();			

	}//End of while loop
	}//End Try
	catch (IOException e)
	{
		System.out.println(e);
	}//End Catch

			
 	}//End 

}
