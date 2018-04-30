import java.io.*;
import java.net.*;
import java.util.*;

public class javaclient{

  public static void main (String [] args){
    
    try{
	  
	  //Create a client socket 
	  Socket MyClient = new Socket("192.168.195.128",36846);
  	  
	  //Input Stream
      DataInputStream input = new DataInputStream(MyClient.getInputStream()); 
	
	  //Output Stream to server
	  DataOutputStream outToServer = new DataOutputStream(MyClient.getOutputStream()); 

	  //BufferedWriter to server
	  PrintStream toServer = new PrintStream(new PrintStream(outToServer), true);
	  
	  //BufferedReader from server
	  BufferedReader fromServer = new BufferedReader(new InputStreamReader(System.in));      

	  //BufferedReader from user
	  BufferedReader fromUser = new BufferedReader(new InputStreamReader(MyClient.getInputStream()));
	  
	  //Declaration of receive & send msg
	  String recv_msg, send_msg;

	  while(true){

	  //Send output to server
      System.out.println("\nEnter your message: \n");
 	  send_msg = fromUser.readLine();
	  //byte [] bytes = send_msg.getBytes();
 	  toServer.print(send_msg);
   	  //toServer.flush();
	
      //Receive server message first
	  if((recv_msg = fromServer.readLine()) !=  null){
	  System.out.println("\nMessage Received: " + recv_msg);	
	   }
	
	  //Reply back server message
	  System.out.println("Enter your request: \n");
	  
	  send_msg = fromUser.readLine();
	  toServer.print(send_msg);
 	  //toServer.flush();

	//Close socket
	MyClient.close();

        }//End of while loop
	  }//End Try
	catch (IOException e)
	{
		System.out.println(e);
	}//End catch
    
	}//End 
}
