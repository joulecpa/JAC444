import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This Client class will act as a Client that sends requests to the Server class
 * to process Student Objects.
 * <p>
 * The activity that the server will perform is the assigning of the registered id
 * for each Student. The id will be equal to the hashCode of the Student object. 
 * The client will also send requests to find if a course of a particular time in
 * the TimeTable object it sends to the server.
 * The client will send the server the objects it wants to have processed. This
 * Client class is based on the StudentClient.java from Part A.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */

public class Client{

   /**
   * Only method in the Client class is the main.
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
      TimeTable tt = new TimeTable("TestData.txt");
      int[] time = new int[2]; //index 1 is the period and 2 is the day
      String[] inputQuestion = new String[2];
      inputQuestion[0] = "Enter Period: ";
      inputQuestion[1] = "Enter Day: ";
      Scanner cin = null;
      String course;

      //me before invoking the server
      System.out.println("Me as a Student before the server invocation:");
      System.out.println(me.toString());

      try{

        //Student stuff
        //Send an object to the server
        outToServer.writeObject(me);
        outToServer.flush();
        System.out.println("Sent a Student Object for processing");

        //Recieve object from server
        me = (Student) inFromServer.readObject();
        System.out.println("Recieved a Student Object from the server");

        //TimeTable stuff
        outToServer.writeObject(tt);
        outToServer.flush();
        System.out.println("Sent a TimeTable Object for processing");

        //Get input for checking the TimeTable
        System.out.println("Check Time Table \n Enter the period and day of week as numbers.");
        System.out.println("Period can be from 1 - 12");
        System.out.println("Days: Mon - 1, Tue - 2, Wed - 3, Thurs - 4, Fri - 5");
        cin = new Scanner(System.in);
        for (int i = 0; i < 2; i++){

          System.out.print(inputQuestion[i]);
          time[i] = cin.nextInt();
        }
        time[0] -= 1;
        time[1] -= 1;
        
        //Send the user input to the server
        outToServer.writeObject(time);
        outToServer.flush();

        //Get the server's return output
        course = (String) inFromServer.readObject();

        System.out.println("At period " + (time[0] + 1) + " on day " + (time[1] + 1) + 
            " you have a " + course + " period.");

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
