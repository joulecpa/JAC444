import java.io.*;
import java.net.*;

/**
 * This Server class will act as a Server that processes StudentTime objects.
 * <p>
 * The functionality is identical to that of PartB except that it now uses StudentTime
 * objects which are a combination of the Student and TimeTable classes.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.2
 */

public class ThreadedServer{

  /**
   * Only method in the Server class is the main.
   * <p>
   * Accepts requests from clients. Processes those requests then returns the Objects that
   * were processed.
   * @return void
   */
  public static void main(String[] args){

    System.out.println("Server started. The server will stop after 3 threads.");
    ServerSocket s = null;

    try{
      s = new ServerSocket(4113); //My Stud #
      int i = 0;

      for (;;){
        if (i == 3) //Used just to stop the server
          break;
        Socket incoming = s.accept();
        System.out.println("Spawning " + i++);
        System.out.println("Connected to: " + incoming.getInetAddress()
          + " at port: " + incoming.getLocalPort());
        new ThreadedServerHandler(incoming, i).start();
      }

    } catch (Exception e){
        System.out.println(e);
    } finally {
        try{
          s.close();
        }
        catch (Exception e){
          System.out.println(e);
        }
    }

    
  }

}

class ThreadedServerHandler extends Thread{

  private Socket incoming;
  private int client;

  public ThreadedServerHandler(Socket i, int c){

    incoming = i;
    client = c;
  }

  public void run(){

    try{

      //Connect input and output streams to the socket
      ObjectOutputStream outToClient = new ObjectOutputStream(incoming.getOutputStream());
      ObjectInputStream inFromClient = new ObjectInputStream(incoming.getInputStream());

      //Exchange Student and TimeTable Object with the client
      StudentTime studTime;
      int[] time;
      String course;

      try{
        
        while(true){ //While there is data from the client

          //StudentTime stuff
          studTime = (StudentTime) inFromClient.readObject();
          System.out.println("Recieved a StudentTime Object from client");

          //Assign the registered id for the Student with the Student's hashCode
          studTime.setRegId(studTime.hashCode());

          //Send Object back to client 
          outToClient.writeObject(studTime);
          outToClient.flush();
          System.out.println("Sent StudentTime Object back to client");

          //Serialize the TimeTable object into a file
          String filename = studTime.getRegId() + "_timetable.txt";
          studTime.serializeObject(filename);

          //Get the input to check the schedule
          time = (int[]) inFromClient.readObject();

          //Deserialize the object from file
          studTime.deserializeObject(filename);

          //Get the course at that time
          course = studTime.checkSchedule(time[0], time[1]);

          outToClient.writeObject(course);
          outToClient.flush();

          System.out.println("Returned the result of checking the schedule");

          System.out.println("Thread# " + client);
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
      incoming.close(); 
    
    }//End outter try
    catch (IOException ioe){
      ioe.printStackTrace();
    }

  }

}

