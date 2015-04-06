import java.io.*;
import java.net.*;

/**
 * This Server class will act as a Server that processes Students Objects as well
 * as processing TimeTable objects.
 * <p>
 * The activity that the server will perform is the assigning of the registered id
 * for each Student. The id will be equal to the hashCode of the Student object. The 
 * server will also process TimeTable objects by serializing and deserializing them.
 * This server class is based off the StudentServer in PartA.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */

public class Server{

  /**
   * Only method in the Server class is the main.
   * <p>
   * Accepts requests from clients. Processes those requests then returns the Objects that
   * were processed.
   * @return void
   */
  public static void main(String[] args){

    System.out.println("Server started.");

    try{
      //Open a socket for listening and then listen for client requests
      ServerSocket s = new ServerSocket(4113); //My Student #
      Socket clientSocket = s.accept();

      System.out.println("Connected to: " + clientSocket.getInetAddress()
          + " at port: " + clientSocket.getLocalPort());

      //Connect input and output streams to the socket
      ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
      ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

      //Exchange Student and TimeTable Object with the client
      Student stud;
      TimeTable tTable;
      int[] time;
      String course;

      try{
        
        while(true){ //While there is data from the client

          //Student stuff

          //Read the object from the client
          stud = (Student) inFromClient.readObject();
          System.out.println("Recieved Student Object from client");

          //Assign the registered id for the Student with the Student's hashCode
          stud.setRegId(stud.hashCode());

          //Send the edited Student Object back to the client then flush the output stream
          outToClient.writeObject(stud);
          outToClient.flush();
          System.out.println("Send Student Object back to client");
        
          //TimeTable stuff
          
          //Read the object from the client
          tTable = (TimeTable) inFromClient.readObject();
          System.out.println("Recieved TimeTable Object from client");

          //Serialize the TimeTable object into a file
          String filename = stud.getRegId() + "_timetable.txt";
          tTable.serializeObject(filename);

          //Get the input to check the schedule
          time = (int[]) inFromClient.readObject();

          //Deserialize the object from file
          tTable.deserializeObject(filename);

          //Get the course at that time
          course = tTable.checkSchedule(time[0], time[1]);

          outToClient.writeObject(course);
          outToClient.flush();

          System.out.println("Returned the result of checking the schedule");


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

