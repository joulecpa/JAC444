/**
 * The Shape class is an abstract class that will be the basis
 * for all other shape classes that will be made.
 * <p>
 * There are two methods that will be in the shape class.
 * getPerimeter and getArea will get the respective values of the shape. 
 * The shapes that will be extended from this base class will be circle, square, 
 * rectangle, triangle and parallelogram.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public abstract class Shape{
  
  /**
   * Retrives the perimeter of the shape.
   * <p>
   * Abstract. Will be implemented by the derived class.
   * @return double The perimeter of the shape.
   */
  abstract double getPerimeter();

  /**
   * Retrives the area of the shape.
   * <p>
   * Abstract. Will be implemented by the derived class.
   * @return double The area of the shape.
   */
  abstract double getArea();
}
