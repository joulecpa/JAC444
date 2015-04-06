import java.io.*;

/**
 * The Student class represents a student.
 * <p>
 * It will have fields: first name, last name, age and registered id.
 * All values are intialized with my own student information except id.
 * This class will have the basic constructors and toString, equals,
 * hashCode and clone methods. There will be also one function setRegId that assigns a value
 * to a student's registered id. Objects of this class is going to be used in conjuction
 * with a java server and client.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public class Student implements Cloneable, Serializable{

  private String firstName;
  private String lastName;
  private int age;
  private int regId;

  /**
   * Default no arg constructor
   */
  public Student(){

    firstName = "Hong Zhan";
    lastName = "Huang";
    age = 25;
  }

  @Override
  /**
   * Override the default toString() method
   * @return String A String representation of the Student object
   */
  public String toString(){
    return "Student\n First Name: " + firstName + " Last Name: " + lastName + " Age: "
      + age + " Registered Id: " + regId + "\n";
  }

  @Override
  /**
   * Override the default hashCode() method
   * @return int A hash of the Student object
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
    if (!(o instanceof Student)) return false;

    Student s = (Student) o;
    if (this.hashCode() != s.hashCode()) return false;
    if (firstName != s.firstName) return false;
    if (lastName != s.lastName) return false;
    if (age != s.age) return false;
    if (regId != s.regId) return false;

    return true; 
  }

  @Override
  /**
   * Override the default clone() method
   * @return Object A clone of this Student object
   * @exception CloneNotSupportedException
   */
  protected Object clone() throws CloneNotSupportedException{
    Student s = (Student) super.clone();
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
}


