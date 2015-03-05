/**
 * The Square represents a square and is derived from the Shape
 * class.
 * <p>
 * Contrary to the Square class in PartA, this Square does not implement getPerimeter or
 * getArea methods. Instead that functionality will be developed via lambdas in the
 * Picture class. The additions the Square class that differs from PartA are the
 * toString, equals and clone methods.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */
public class Square extends Shape implements Cloneable{

  /** The length of the sides of the Square */
  double length; 

  /**
   * Default no argument constructor sets length to 0.
   */
  Square(){
    length = 0;
  }

  /**
   * One argument constructor sets the length to the passed in value.
   * @param l The passed in value for the length.
   */
  Square(double l){
    length = l;
  }

  @Override
  /**
   * toString returns the string representation of the Square.
   * @return String The string representation of the Square.
   */
  public String toString(){
    return "This Square object has sides of length: " + length + ".\n";
  }

  @Override
  /**
   * equals compares whether the current object is equal to the passed in object.
   * @return boolean True if the objects are equal and false otherwise.
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Square)) return false;

    Square s = (Square) o;
    if (length != s.length) return false;

    return true;
  }

  @Override
  /**
   * Dummy hashCode for the purpose of supressing warnings.
   * @return int Returns 0.
   */
  public int hashCode(){

    return 0;
  }

  @Override
  /**
   * clone will create a clone of the current Square object.
   * @exception CloneNotSupportedException
   * @return Object The clone of the current Square object.
   */
  protected Object clone() throws CloneNotSupportedException{
    Square s = (Square) super.clone();
    return s;
  }
}
