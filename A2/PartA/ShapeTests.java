import static org.junit.Assert.*;
import org.junit.Test;


/**
 * This class is used to test all the Shape classes.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */

public class ShapeTests{

  //Circle Tests *************
  Circle c = new Circle(); //Circle with 0 radius
  Circle c2 = new Circle(5); //Circle with non-zero radius

  @Test
  public void testGetPerimeterCircle(){
    double c2_p = 10 * Math.PI; //perimeter for a circle with radius 5
    assertEquals("Test for circle with a zero radius: ", 0, c.getPerimeter(), 0.01);
    assertEquals("Test for circle with non-zero radius: ", c2_p, c2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetAreaCircle(){
    double c2_a = 25 * Math.PI; //area for a circle with radius 5
    assertEquals("Test for circle with a zero radius: ", 0, c.getArea(), 0.01);
    assertEquals("Test for circle with a non-zero radius: ", c2_a, c2.getArea(), 0.01);
  }

  //Square Tests *************
  Square s = new Square(); //Square with 0 length
  Square s2 = new Square(5); //Square with non-zero length

  @Test
  public void testGetPerimeterSquare(){
    double s2_p = 4 * 5; //perimeter for a square with length 5
    assertEquals("Test for square with a zero length: ", 0, s.getPerimeter(), 0.01);
    assertEquals("Test for square with non-zero length: ", s2_p, s2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetAreaSquare(){
    double s2_a = 5 * 5; //area for a square with length 5
    assertEquals("Test for square with a zero length: ", 0, s.getArea(), 0.01);
    assertEquals("Test for square with a non-zero length: ", s2_a, s2.getArea(), 0.01);
  }

  //Rectangle Tests *************
  Rectangle r = new Rectangle(); //Rectangle with 0 length and width
  Rectangle r2 = new Rectangle(5, 4); //Rectangle with non-zero length and width

  @Test
  public void testGetPerimeterRectangle(){
    double r2_p = 10 + 8; //perimeter for a rectangle with length 5
    assertEquals("Test for rectangle with a zero length: ", 0, r.getPerimeter(), 0.01);
    assertEquals("Test for rectangle with non-zero length: ", r2_p, r2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetAreaRectangle(){
    double r2_a = 5 * 4; //area for a rectangle with length 5
    assertEquals("Test for rectangle with a zero length: ", 0, r.getArea(), 0.01);
    assertEquals("Test for rectangle with a non-zero length: ", r2_a, r2.getArea(), 0.01);
  }

  //Triangle Tests *************
  Triangle t = new Triangle(); //Triangle with 0 length sides
  Triangle t2 = new Triangle(5, 4, 3); //Triangle with non-zero length sides

  @Test
  public void testGetPerimeterTriangle(){
    double t2_p = 12; //perimeter for a triangle with side lengths 5, 4, 3
    assertEquals("Test for triangle with a zero length: ", 0, t.getPerimeter(), 0.01);
    assertEquals("Test for triangle with non-zero length: ", t2_p, t2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetAreaTriangle(){
    double s = (5 + 4 + 3)/2; //semi perimeter for the triangle
    double t2_a = Math.sqrt(s * (s - 5) * (s - 4) * (s - 3)); //area of the triangle
    assertEquals("Test for triangle with a zero length: ", 0, t.getArea(), 0.01);
    assertEquals("Test for triangle with a non-zero length: ", t2_a, t2.getArea(), 0.01);
  }

  //Parallelogram Tests ***************
  Parallelogram p = new Parallelogram(); //Parallelogram with 0 values
  Parallelogram p2 = new Parallelogram(5, 4, 3); //Parallelogram with non-zero values

  @Test
  public void testGetPerimeterParallelogram(){
    double p2_p = 10 + 8; //perimeter for a parallelogram with length 5, width 4, height 3
    assertEquals("Test for parallelogram with a zero values: ", 0, p.getPerimeter(), 0.01);
    assertEquals("Test for parallelogram with non-zero values: ", 
        p2_p, p2.getPerimeter(), 0.01);
  }

  @Test
  public void testGetAreaParallelogram(){
    double p2_a = 5 * 3; //area for a parallelogram with length 5
    assertEquals("Test for parallelogram with a zero values: ", 0, p.getArea(), 0.01);
    assertEquals("Test for parallelogram with a non-zero values: ", 
        p2_a, p2.getArea(), 0.01);
  }
}
