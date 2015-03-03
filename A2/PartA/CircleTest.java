import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is used to test the Circle class.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class CircleTest{

  Circle c = new Circle(); //Circle with 0 radius
  Circle c2 = new Circle(5); //Circle with non-zero radius

  @Test
  public void testGetPerimeter(){
    double c2_p = 10 * Math.PI; //perimeter for a circle with radius 5
    assertEquals("Test for circle with a zero radius: ", 0, c.getPerimeter(), 0.01);
    assertEquals("Test for circle with non-zero radius: ", c2_p, c2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetArea(){
    double c2_a = 25 * Math.PI; //area for a circle with radius 5
    assertEquals("Test for circle with a zero radius: ", 0, c.getArea(), 0.01);
    assertEquals("Test for circle with a non-zero radius: ", c2_a, c2.getArea(), 0.01);
  }
}
