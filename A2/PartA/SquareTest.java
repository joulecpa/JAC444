import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is used to test the Square class.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class SquareTest{

  Square s = new Square(); //Square with 0 length
  Square s2 = new Square(5); //Square with non-zero length

  @Test
  public void testGetPerimeter(){
    double s2_p = 4 * 5; //perimeter for a square with length 5
    assertEquals("Test for square with a zero length: ", 0, s.getPerimeter(), 0.01);
    assertEquals("Test for square with non-zero length: ", s2_p, s2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetArea(){
    double s2_a = 5 * 5; //area for a square with length 5
    assertEquals("Test for square with a zero length: ", 0, s.getArea(), 0.01);
    assertEquals("Test for square with a non-zero length: ", s2_a, s2.getArea(), 0.01);
  }
}

