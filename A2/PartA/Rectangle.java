/**
 * The Rectangle represents a rectangle and is derived from the Shape
 * class.
 * <p>
 * It implements the two methods inherited from Shape: getPerimeter and
 * getArea.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Rectangle extends Shape{

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
   * getPerimeter calculates the perimeter of the Rectangle with 2length + 2width.
   * @return double The perimeter of the Rectangle.
   */
  double getPerimeter(){
    return (2 * length) + (2 * width);
  }

  @Override
  /**
   * getArea calculates the area of the Rectangle with length * width.
   * @return double The area of the Rectangle.
   */
  double getArea(){
    return length * width;
  }
}
