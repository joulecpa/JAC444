import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This Client class will act as a Client that sends requests to the Server class
 * to process StudentTime Objects.
 * <p>
 * The functionality is identical to that of PartB except that it now uses StudentTime
 * objects which are a combination of the Student and TimeTable classes.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.2
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
      StudentTime st = new StudentTime("TestData.txt");
      int[] time = new int[2]; //index 1 is the period and 2 is the day
      String[] inputQuestion = new String[2];
      inputQuestion[0] = "Enter Period: ";
      inputQuestion[1] = "Enter Day: ";
      Scanner cin = null;
      String course;

      //me before invoking the server
      System.out.println("Me as a Student before the server invocation:");
      System.out.println(st.toString());

      try{

        //StudentTime
        //Send a object for processing
        outToServer.writeObject(st);
        outToServer.flush();
        System.out.println("Sent a StudentTime Object for processing");

        //Recieve a object back from processing
        st = (StudentTime) inFromServer.readObject();
        System.out.println("Recieved a StudentTime Object from Server");

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
      System.out.println(st.toString());
      
    }
    catch (IOException ioe){
      ioe.printStackTrace();
    } 

    System.out.println("End of the client");

  }
}
