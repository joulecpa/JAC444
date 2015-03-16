/**
 * The Triangle represents a triangle and is derived from the Shape
 * class.
 * <p>
 * It implements the two methods inherited from Shape: getPerimeter and
 * getArea.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Triangle extends Shape{

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
    if (a == 0 || b == 0 || c == 0
			|| a + b < c || a + c < b || b + c < a){
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
   * getPerimeter calculates the perimeter of the Triangle with the sum of the sides.
   * @return double The perimeter of the Triangle.
   */
  double getPerimeter(){
    return side_a + side_b + side_c;
  }

  @Override
  /**
   * getArea calculates the area of the Triangle.
   * <p>
   * The formula used is √s (s-a)(s-b)(s-c) where s is the semiperimeter and
   * a,b and c are the sides of the triangle. The semiperimeter is calculated by
   * (a + b + c)/2.
   * @return double The area of the Triangle.
   */
  double getArea(){
    double s_p = (side_a + side_b + side_c) / 2; //s_p as in semiperimeter
    return Math.sqrt(s_p * (s_p - side_a) * (s_p - side_b) * (s_p - side_c));
  }
}
