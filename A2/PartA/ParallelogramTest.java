import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is used to test the Parallelogram class.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class ParallelogramTest{

  Parallelogram p = new Parallelogram(); //Parallelogram with 0 values
  Parallelogram p2 = new Parallelogram(5, 4, 3); //Parallelogram with non-zero values

  @Test
  public void testGetPerimeter(){
    double p2_p = 10 + 8; //perimeter for a parallelogram with length 5, width 4, height 3
    assertEquals("Test for parallelogram with a zero values: ", 0, p.getPerimeter(), 0.01);
    assertEquals("Test for parallelogram with non-zero values: ", 
        p2_p, p2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetArea(){
    double p2_a = 5 * 3; //area for a parallelogram with length 5
    assertEquals("Test for parallelogram with a zero values: ", 0, p.getArea(), 0.01);
    assertEquals("Test for parallelogram with a non-zero values: ", 
        p2_a, p2.getArea(), 0.01);
  }
}


