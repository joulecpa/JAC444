import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
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

  Picture p; //Input text file will have no empty space gaps between entries
  Picture pGap; //Input Input file will have gaps between entries

  //This will setup Picture p before each test is run. Requires the @Before annotation
  //which is imported from org.junit.Before
  @Before
  public void setUp(){

    try {
      p = new Picture("Test.txt");
      pGap = new Picture("Test2.txt");
    }
    catch (Exception e){
      System.out.println("Exception " + e.getMessage() + " caught.");
    }
  }

  @Test
  public void testGetPerimeter(){
    assertEquals("Test for picture with Test.txt: ", 170.83, p.getPerimeter(), 0.01); 
    assertEquals("Test for picture with Test2.txt: ", 166.83, pGap.getPerimeter(), 0.01); 
  }

  @Test
  public void testGetArea(){
    assertEquals("Test for picture with Test.txt: ", 268.07, p.getArea(), 0.01);  
    assertEquals("Test for picture with Test2.txt: ", 267.07, pGap.getArea(), 0.01);  
  }

  
  @Test
  public void testGetPerimeterMax(){
    //p.getPerimeter(); //To set the perimeterMax
    assertEquals("Test for picture with Test.txt: ", 31.41, p.getPerimeterMax(), 0.01);
  }

  @Test
  public void testGetAreaMin(){
    //p.getArea(); //To set the areaMin
    assertEquals("Test for picture with Test.txt: ", 1, p.getAreaMin(), 0.01);
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
