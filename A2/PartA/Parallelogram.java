/**
 * The Parallelogram represents a parallelogram and is derived from the Shape
 * class.
 * <p>
 * It implements the two methods inherited from Shape: getPerimeter and
 * getArea.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Parallelogram extends Shape{

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
   * getPerimeter calculates the perimeter of the Parallelogram with 2length + 2width.
   * @return double The perimeter of the Parallelogram.
   */
  double getPerimeter(){
    return (2 * length) + (2 * width);
  }

  @Override
  /**
   * getArea calculates the area of the Parallelogram with length * height.
   * @return double The area of the Parallelogram.
   */
  double getArea(){
    return length * height; 
  }
}
