/**
 * The Circle represents a circle and is derived from the Shape
 * class.
 * <p>
 * Contrary to the Circle class in PartA, this Circle does not implement getPerimeter or
 * getArea methods. Instead that functionality will be developed via lambdas in the
 * Picture class. The additions the Circle class that differs from PartA are the
 * toString, equals and clone methods.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */
public class Circle extends Shape implements Cloneable{

  /** The radius of the Circle */
  double radius; 

  /**
   * Default no argument constructor sets radius to 0.
   */
  Circle(){
    radius = 0;
  }

  /**
   * One argument constructor sets the radius to the passed in value.
   * @param r The passed in value for the radius.
   */
  Circle(double r){
    radius = r;
  }

  /**
   * getter for the radius of the Circle.
   * @return double Radius of the Circle.
   */
  double getRadius(){
    return radius;
  }
  @Override
  /**
   * toString returns the string representation of the circle.
   * @return String The string representation of the Circle.
   */
  public String toString(){
    return "This Circle object has the radius of " + radius + ".\n";
  }

  @Override
  /**
   * equals compares whether the current object is equal to the passed in object.
   * @return boolean True if the objects are equal and false otherwise.
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Circle)) return false;

    Circle c = (Circle) o;
    if (radius != c.radius) return false;

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
   * clone will create a clone of the current Circle object.
   * @exception CloneNotSupportedException
   * @return Object The clone of the current Circle object.
   */
  protected Object clone() throws CloneNotSupportedException{
    Circle c = (Circle) super.clone();
    return c;
  }
}
