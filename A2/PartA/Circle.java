/**
 * The Circle represents a circle and is derived from the Shape
 * class.
 * <p>
 * It implements the two methods inherited from Shape: getPerimeter and
 * getArea.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Circle extends Shape{

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

  @Override
  /**
   * getPerimeter calculates the perimeter of the Circle with 2ΠR.
   * @return double The perimeter of the Circle.
   */
  double getPerimeter(){
    return 2 * Math.PI * radius;
  }

  @Override
  /**
   * getArea calculates the area of the Circle with ΠR².
   * @return double The area of the Circle.
   */
  double getArea(){
    return Math.PI * (radius * radius);
  }
}
