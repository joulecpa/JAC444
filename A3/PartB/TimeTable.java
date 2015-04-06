import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The TimeTable class represents a student's time table.
 * <p>
 * The contents of a TimeTable object is intialized from a text file. Each line
 * of the text file represents a period for every day of the week starting from
 * Monday to Friday. Each line has strings delimited by commas. Any string is the
 * name of the course or if it is empty it means it is a free period. The class also
 * contains methods for serialization and deserialization as well as a method to
 * check whether a slot in the time table is a free period or a course period.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public class TimeTable implements Cloneable, Serializable{

  private List<String[]> schedule;

  /**
   * Default constructor that intializes the schedule from a text file.
   * @param filename The file to be read to initalize our schedule
   */
  public TimeTable(String filename) throws IOException{

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
   * @return String A String representation of the TimeTable object
   */
  public String toString(){
    String tmp = "";

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
   * @return int The hash of the TimeTable object
   */
  public int hashCode(){
    int h = 0;
    for (int i = 0; i < 12; i++)
      for (String str : schedule.get(i))
        h += str.hashCode();

    return (h < 0 ? -h : h);
  }

  @Override
  /**
   * Override the default equals() method
   * @param o Object to compare with this object
   * @return boolean True if equal to this object false otherwise
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof TimeTable)) return false;

    TimeTable t = (TimeTable) o;
    if (this.hashCode() != t.hashCode()) return false;
    for (int i = 0; i < 12; i++){
      String[] a = schedule.get(i);
      String[] b = t.schedule.get(i);

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
   * @return Object The clone of this TimeTable object
   * @exception CloneNotSupportedException
   */
  protected Object clone() throws CloneNotSupportedException{
    TimeTable t = (TimeTable) super.clone();

    for (int i = 0; i < 12; i++){
      t.schedule.add(schedule.get(i));
    }

    return t;
  }

  /**
   * Serializes the TimeTable object to the file specified by the filename.
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
   * Deserializes a TimeTable object from a file specified by the filename
   * @param filename The file to deserialize from
   * @exception IOException
   */
  public void deserializeObject(String filename) throws IOException{

    TimeTable ret = null;

    try{

      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);
      ret = (TimeTable) ois.readObject();

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

  /*
  public static void main(String[] args){

    try {
      TimeTable t = new TimeTable("TestData.txt");

      t.serializeObject("TestWrite.txt");

      TimeTable s = deserializeObject("TestWrite.txt");

      System.out.println(s.toString());

      System.out.println(s.checkSchedule(0,1));
    }
    catch (IOException ioe){
      ioe.printStackTrace();
    }
  }
  */

}
