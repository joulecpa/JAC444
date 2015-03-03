import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is used to test the Rectangle class.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class RectangleTest{

  Rectangle r = new Rectangle(); //Rectangle with 0 length and width
  Rectangle r2 = new Rectangle(5, 4); //Rectangle with non-zero length and width

  @Test
  public void testGetPerimeter(){
    double r2_p = 10 + 8; //perimeter for a rectangle with length 5
    assertEquals("Test for rectangle with a zero length: ", 0, r.getPerimeter(), 0.01);
    assertEquals("Test for rectangle with non-zero length: ", r2_p, r2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetArea(){
    double r2_a = 5 * 4; //area for a rectangle with length 5
    assertEquals("Test for rectangle with a zero length: ", 0, r.getArea(), 0.01);
    assertEquals("Test for rectangle with a non-zero length: ", r2_a, r2.getArea(), 0.01);
  }
}

