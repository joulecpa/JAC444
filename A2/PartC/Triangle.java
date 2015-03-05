/**
 * The Triangle represents a triangle and is derived from the Shape
 * class.
 * <p>
 * Contrary to the Triangle class in PartA, this Triangle does not implement getPerimeter
 * or getArea methods. Instead that functionality will be developed via lambdas in the
 * Picture class. The additions the Triangle class that differs from PartA are the
 * toString, equals and clone methods.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */
public class Triangle extends Shape implements Cloneable{

  /** The first side of the Triangle */
  double side_a;

  /** The second side of the Triangle */
  double side_b; 

  /** The third side of the Triangle */
  double side_c; 
  

  /**
   * Default no argument constructor sets all sides to 0.
   */
  Triangle(){
    side_a = side_b = side_c = 0;
  }

  /**
   * Three argument constructor sets the sides to the passed in values.
   * @param a The passed in value for the side_a.
   * @param b The passed in value for the side_b.
   * @param c The passed in value for the side_c.
   */
  Triangle(double a, double b, double c){
    if (a == 0 || b == 0 || c == 0){
      side_a = side_b = side_c = 0;
    }
    else{
      side_a = a;
      side_b = b;
      side_c = c;
    }
  }

  @Override
  /**
   * toString returns the string representation of the Triangle.
   * @return String The string representation of the Triangle.
   */
  public String toString(){
    return "This Triangle object has sides a, b, c of length " + 
      side_a + " " + side_b + " " + side_c + " respectively.\n";
  }

  @Override
  /**
   * equals compares whether the current object is equal to the passed in object.
   * @return boolean True if the objects are equal and false otherwise.
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Triangle)) return false;

    Triangle t = (Triangle) o;
    if (side_a != t.side_a) return false;
    if (side_b != t.side_b) return false;
    if (side_c != t.side_c) return false;

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
   * clone will create a clone of the current Triangle object.
   * @exception CloneNotSupportedException
   * @return Object The clone of the current Triangle object.
   */
  protected Object clone() throws CloneNotSupportedException{
    Triangle t = (Triangle) super.clone();
    return t;
  }
}
