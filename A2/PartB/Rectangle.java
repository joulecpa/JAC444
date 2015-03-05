/**
 * The Rectangle represents a rectangle and is derived from the Shape
 * class.
 * <p>
 * Contrary to the Rectangle class in PartA, this Rectangle does not implement getPerimeter
 * or getArea methods. Instead that functionality will be developed via lambdas in the
 * Picture class. The additions the Rectangle class that differs from PartA are the
 * toString, equals and clone methods.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */
public class Rectangle extends Shape implements Cloneable{

  /** The length of the Rectangle */
  double length;

  /** The width of the Rectangle */
  double width; 

  /**
   * Default no argument constructor sets length and width to 0.
   */
  Rectangle(){
    length = width = 0;
  }

  /**
   * Two argument constructor sets the length and width to the passed in values.
   * @param l The passed in value for the length.
   * @param w The passed in value for the width.
   */
  Rectangle(double l, double w){
    if (l == 0 || w == 0)
      length = width = 0;
    else{
      length = l;
      width = w;
    }
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
   * toString returns the string representation of the Rectangle.
   * @return String The string representation of the Rectangle.
   */
  public String toString(){
    return "This Rectangle object has length: " + length + " and width: " + width + ".\n";
  }

  @Override
  /**
   * equals compares whether the current object is equal to the passed in object.
   * @return boolean True if the objects are equal and false otherwise.
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Rectangle)) return false;

    Rectangle r = (Rectangle) o;
    if (length != r.length) return false;
    if (width != r.width) return false;

    return true;
  }

  @Override
  /**
   * clone will create a clone of the current Rectangle object.
   * @exception CloneNotSupportedException
   * @return Object The clone of the current Rectangle object.
   */
  protected Object clone() throws CloneNotSupportedException{
    Rectangle r = (Rectangle) super.clone();
    return r;
  }
}
