import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.runner.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;


/**
 * This class is used to test the Picture class.
 * <p>
 * It tests whether the two methods getPerimeter and getArea are working
 * properly.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class PictureTest{

  //Listing out the Perimeter and Area of each shape in the picture for reference
  ArrayList<Shape> shapelist = new ArrayList<Shape>();
  boolean ci = shapelist.add(new Circle(5)); //P: 31.41, A: 78.53 
  boolean sq = shapelist.add(new Square(2)); //P: 8, A: 4
  boolean rc = shapelist.add(new Rectangle(3, 4)); //P: 14, A: 12
  boolean tr = shapelist.add(new Triangle(3, 4, 5)); //P: 12, A: 6
  boolean pr = shapelist.add(new Parallelogram(5, 6, 7)); //P: 22, A: 35

  Picture p = new Picture(shapelist); 
  
  @Test
  public void testGetPerimeter(){
    assertEquals("Test for picture with one of each shape: ", 87.41, p.getPerimeter(), 0.01);  
  }

  @Test
  public void testGetArea(){
    assertEquals("Test for picture with one of each shape: ", 135.53, p.getArea(), 0.01);  
  }

  public static void main(String[] args){

    //Picture Test
    Result pictureResults = JUnitCore.runClasses(PictureTest.class);
    System.out.println("The tests for the Picture class");
    for (Failure fail : pictureResults.getFailures())
      System.out.println(fail);
    if (pictureResults.wasSuccessful())
      System.out.println("Passed all the Picture tests!\n");      
  }
}
