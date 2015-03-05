/**
 * The Parallelogram represents a parallelogram and is derived from the Shape
 * class.
 * <p>
 * Contrary to the Parallelogram class in PartA, this Parallelogram does not implement 
 * getPerimeter or getArea methods. Instead that functionality will be developed via 
 * lambdas in the Picture class. The additions the Parallelogram class that differs from 
 * PartA are the toString, equals and clone methods.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */
public class Parallelogram extends Shape implements Cloneable{

  /** The length of the Parallelogram */
  double length;

  /** The width of the Parallelogram */
  double width; 

  /** The height of the Parallelogram */
  double height; 
  

  /**
   * Default no argument constructor sets length, width and height to 0.
   */
  Parallelogram(){
    length = width = height = 0;
  }

  /**
   * Three argument constructor sets the length, width and height to the passed in values.
   * @param l The passed in value for the length.
   * @param w The passed in value for the width.
   * @param h The passed in value for the height.
   */
  Parallelogram(double l, double w, double h){
    if(l == 0 || w == 0 || h == 0){
      length = width = height = 0;  
    }
    else{
      length = l;
      width = w;
      height = h;
    }
  }

  @Override
  /**
   * toString returns the string representation of the Parallelogram.
   * @return String The string representation of the Parallelogram.
   */
  public String toString(){
    return "This Parallelogram object has length, width and height of " +
      length + " " + width + " " + height + " respectively.\n";
  }

  @Override
  /**
   * equals compares whether the current object is equal to the passed in object.
   * @return boolean True if the objects are equal and false otherwise.
   */
  public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Parallelogram)) return false;

    Parallelogram p = (Parallelogram) o;
    if (length != p.length) return false;
    if (width != p.width) return false;
    if (height != p.height) return false;

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
   * clone will create a clone of the current Parallelogram object.
   * @exception CloneNotSupportedException
   * @return Object The clone of the current Parallelogram object.
   */
  protected Object clone() throws CloneNotSupportedException{
    Parallelogram p = (Parallelogram) super.clone();
    return p;
  }
}
