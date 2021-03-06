import java.io.*;
import java.net.*;

/**
 * This StudentServer class will act as a Server that processes Students Objects.
 * <p>
 * The activity that the server will perform is the assigning of the registered id
 * for each Student. The id will be equal to the hashCode of the Student object.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public class StudentServer{

  /**
   * Only method in the StudentServer class is the main.
   * <p>
   * Accepts requests from clients. Processes those requests then returns the Objects that
   * were processed.
   * @return void
   */
  public static void main(String[] args){

    System.out.println("StudentServer started.");

    try{
      //Open a socket for listening and then listen for client requests
      ServerSocket s = new ServerSocket(4113); //My Student #
      Socket clientSocket = s.accept();

      System.out.println("Connected to: " + clientSocket.getInetAddress()
          + " at port: " + clientSocket.getLocalPort());

      //Connect input and output streams to the socket
      ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
      ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

      //Exchange Student Object with the client
      Student stud;

      try{
        
        while(true){ //While there is data from the client
          //Read the object from the client
          stud = (Student) inFromClient.readObject();
          System.out.println("Recieved Student Object from client");

          //Assign the registered id for the Student with the Student's hashCode
          stud.setRegId(stud.hashCode());

          //Send the edited Student Object back to the client then flush the output stream
          outToClient.writeObject(stud);
          outToClient.flush();
          System.out.println("Send Student Object back to client");
        }

      } //End try
      catch (ClassNotFoundException cnf){
        cnf.printStackTrace();
      }
      catch (EOFException eof){
        System.out.println("The client has terminated the session");
      }
      catch (IOException ioe){
        ioe.printStackTrace();
      }

      //Close the connection to the client
      outToClient.close();
      inFromClient.close();
      clientSocket.close();

    } //End try
    catch (IOException ioe){
      ioe.printStackTrace();
    }
  }
}

