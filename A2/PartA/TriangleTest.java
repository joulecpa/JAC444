import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is used to test the Triangle class.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class TriangleTest{

  Triangle t = new Triangle(); //Triangle with 0 length sides
  Triangle t2 = new Triangle(5, 4, 3); //Triangle with non-zero length sides

  @Test
  public void testGetPerimeter(){
    double t2_p = 12; //perimeter for a triangle with side lengths 5, 4, 3
    assertEquals("Test for triangle with a zero length: ", 0, t.getPerimeter(), 0.01);
    assertEquals("Test for triangle with non-zero length: ", t2_p, t2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetArea(){
    double s = (5 + 4 + 3)/2; //semi perimeter for the triangle
    double t2_a = Math.sqrt(s * (s - 5) * (s - 4) * (s - 3)); //area of the triangle
    assertEquals("Test for triangle with a zero length: ", 0, t.getArea(), 0.01);
    assertEquals("Test for triangle with a non-zero length: ", t2_a, t2.getArea(), 0.01);
  }
}


