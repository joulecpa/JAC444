/**
 * The Square represents a square and is derived from the Shape
 * class.
 * <p>
 * It implements the two methods inherited from Shape: getPerimeter and
 * getArea.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Square extends Shape{

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
   * getPerimeter calculates the perimeter of the Square with 4 * length.
   * @return double The perimeter of the Square.
   */
  double getPerimeter(){
    return 4 * length;
  }

  @Override
  /**
   * getArea calculates the area of the Square with length².
   * @return double The area of the Square.
   */
  double getArea(){
    return length * length;
  }
}
