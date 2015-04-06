import java.io.*;
import java.net.*;

/**
 * This StudentClient class will act as a Client that sends requests to the StudentServer
 * to process Student Objects.
 * <p>
 * The activity that the server will perform is the assigning of the registered id
 * for each Student. The id will be equal to the hashCode of the Student object.
 * The client will send the server the objects it wants to have processed.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public class StudentClient{

   /**
   * Only method in the StudentClient class is the main.
   * <p>
   * Will open the connection to the server and send forth the requests.
   * @return void
   */
  public static void main(String[] args){

    Socket clientSocket;
    try{

      //Connect to the server name: "localhost" port number:4113
      clientSocket = new Socket(InetAddress.getByName("localhost"), 4113);
      System.out.println("Connected to " + clientSocket.getInetAddress().getHostName());

      //Connect input and output streams to the socket
      ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
      System.out.println("I/O streams connected to the socket");

      //Communiate with the server
      Student me = new Student();

      //me before invoking the server
      System.out.println("Me as a Student before the server invocation:");
      System.out.println(me.toString());

      try{

        //Send an object to the server
        outToServer.writeObject(me);
        outToServer.flush();
        System.out.println("Sent a Student Object for processing");

        //Recieve object from server
        me = (Student) inFromServer.readObject();
        System.out.println("Recieved a Student Object from the server");

        //Sleep for a bit
        try{
          Thread.sleep(2000);
        }
        catch (InterruptedException e){}

      } //End try
      catch (ClassNotFoundException cnf){
        cnf.printStackTrace();
      }
      catch (EOFException eof){
        System.out.println("The server has terminated the session");
      }
      catch (IOException ioe){
        ioe.printStackTrace();
      }


      //Close the connection to the server
      outToServer.close();
      inFromServer.close();
      clientSocket.close();

      //me after invoking the server
      System.out.println("Me as a Student after the server invocation:");
      System.out.println(me.toString());
      
    }
    catch (IOException ioe){
      ioe.printStackTrace();
    } 

    System.out.println("End of the client");

  }
}
