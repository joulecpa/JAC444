JAC444-A3

The files for each part are distributed into their respective folders.

Part A:
Student.java
StudentClient.java
StudentServer.java

The student class has information about the student regarding their first and last names, age 
and registered id. The client sends a student object to the server for processing. The processing
that the server does is that it assigns a value to the student's registered id based on the
student's hashcode. After the server finishes its work it then returns the object back to the
client. The student class contains all the classical methods such as toString, equals and such
along with relevant getters and setters.

Part B:

783088801_timetable.txt
Client.java
Server.java
Student.java
TestData.txt
TimeTable.java

In part B we introduce the TimeTable class which represents the time table of a student. This
class initalizes its members from a text file. It also makes use of serialization methods to
serialize TimeTable objects to file and deserialize them from file. The TimeTable class also has
a method to check what a particular spot in the time table is (free period or otherwise)
They are also processed by the server as requests from the client. TestData.txt is the file where
we initialize the object with. 783088801_timetable.txt is the file that the server serialized the 
object it processed to.

There is no validation for user inputs when they are asked to enter a period to check for in the
TimeTable object.

Part C:

783088801_timetable.txt
Client.java
StudentTime.java
TestData.txt
ThreadedServer.java

In part C we combine the Student and TimeTable classes into the StudentTime class. Along with
editing the Client and Server to make use of this newly combined class we also make it so that
the Server portion also a multithreaded server. Beyond that the functionality is the same as 
in part B. For the sake of keeping a simple example the server will end after handling 3 threads.
