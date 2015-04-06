import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The StudentTime class represents a student and their time table.
 * <p>
 * The combination of the Student class and the TimeTable class. 
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public class StudentTime implements Cloneable, Serializable{


  private String firstName;
  private String lastName;
  private int age;
  private int regId;
  private List<String[]> schedule;

  /**
   * Default constructor is a combination of the Student and TimeTable constructor.
   * @param filename The file to intialized the schedule with
   * @exception IOException
   */
  public StudentTime(String filename) throws IOException{

    firstName = "Hong Zhan";
    lastName = "Huang";
    age = 25;

    schedule = new ArrayList<String[]>();

    File f = new File(filename);
    Scanner scanline = new Scanner(f);

    while(scanline.hasNextLine()){
      //Using nested scanners to read the tokens of a particular line
      Scanner scantoken = new Scanner(scanline.nextLine());
      scantoken.useDelimiter(Pattern.compile(","));

      if (!scantoken.hasNext())
        break; //Empty line so we stop parsing

      String[] str = new String[5];
      int i = 0;

      while(scantoken.hasNext()){
        str[i] = scantoken.next();
        i++;
      } //Inner while

      scantoken.close();
      schedule.add(str);

    }//Outter while

    scanline.close();

  }

  @Override
  /**
   * Override the default toString() method
   * @return String A String representation of the StudentTime object
   */
  public String toString(){

    String tmp = "Student\n First Name: " + firstName + " Last Name: " + lastName + " Age: "
      + age + " Registered Id: " + regId + "\n";
 
    for (int i = 0; i < 12; i++){

      for (String str : schedule.get(i)){
        tmp += str;
      }
      tmp += "\n";
    }

    return tmp;

  }

  @Override
  /**
   * Override the default hashCode() method
   * @return int A hash of the StudentTime object
   */
  public int hashCode(){
    int h = (firstName.hashCode() + lastName.hashCode() + age);
    return (h < 0 ? -h : h); 
  }

  @Override
  /**
   * Override the default equals() method
   * @param o The object to be compared to this Student object
   * @return boolean Returns true if given object is equal to this Student object, false otherwise
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof StudentTime)) return false;

    StudentTime s = (StudentTime) o;
    if (this.hashCode() != s.hashCode()) return false;
    if (firstName != s.firstName) return false;
    if (lastName != s.lastName) return false;
    if (age != s.age) return false;
    if (regId != s.regId) return false;
    
    for (int i = 0; i < 12; i++){
      String[] a = schedule.get(i);
      String[] b = s.schedule.get(i);

      for (int j = 0; j < 5; j++)
        if (a[j].compareTo(b[j]) != 0){
          return false;
        }
    }

    return true; 
  }

  @Override
  /**
   * Override the default clone() method
   * @return Object A clone of this Student object
   * @exception CloneNotSupportedException
   */
  protected Object clone() throws CloneNotSupportedException{
    StudentTime s = (StudentTime) super.clone();

    for (int i = 0; i < 12; i++){
      s.schedule.add(schedule.get(i));
    }

    return s;
  }

  /**
   * Gets the regId of the student.
   * @return int The regId of the student
   */
  public int getRegId(){
    return regId;
  }

  /**
   * Sets the regId for the student.
   * @param reg The registered id to be set.
   */
  public void setRegId(int reg){
    regId = reg;
  }

  /**
   * Serializes the StudentTime object to the file specified by the filename.
   * @param filename The file to serialize to
   * @exception IOException
   */
  public void serializeObject(String filename) throws IOException{

    try{
      
      FileOutputStream fos = new FileOutputStream(filename);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);

      oos.flush();
      fos.close();

    }
    catch (Throwable e){
      e.printStackTrace();
    }

  }

  /**
   * Deserializes a StudentTime object from a file specified by the filename
   * @param filename The file to deserialize from
   * @exception IOException
   */
  public void deserializeObject(String filename) throws IOException{

    StudentTime ret = null;

    try{

      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);
      ret = (StudentTime) ois.readObject();

      fis.close();
    }
    catch (Throwable e){
      e.printStackTrace();
    }

    schedule = ret.schedule;
  }

  /**
   * Checks the schedule at a specified period and day to see if that slot is
   * occupied by a class or is a free period.
   * @param period The period of the day (0-11)
   * @param day The day of the week (0-4 for Monday to Friday)
   * @return String The name of the course if it is not a free period, "Free" otherwise
   */
  public String checkSchedule(int period, int day){
    String ret;
    String cmp = "\"\"";

    String[] course = schedule.get(period);
    if (course[day].compareTo(cmp) != 0)
      ret = course[day];
    else
      ret = "Free";

    return ret;
  }

}
