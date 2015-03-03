import org.junit.runner.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

/**
 * This class will run all the individual shape tests in its main.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class RunShapeTests{

  /**
   * Main method where the tests will be run.
   * @return none
   */
  public static void main(String[] args){

    //The Circle tests
    Result circleResults = JUnitCore.runClasses(CircleTest.class);
    System.out.println("The tests for the Circle class");
    for (Failure fail : circleResults.getFailures())
      System.out.println(fail);
    if (circleResults.wasSuccessful())
      System.out.println("Passed all the Circle tests!\n");
    
    //The Square tests
    Result squareResults = JUnitCore.runClasses(SquareTest.class);
    System.out.println("The tests for the Square class");
    for (Failure fail : squareResults.getFailures())
      System.out.println(fail);
    if (squareResults.wasSuccessful())
      System.out.println("Passed all the Square tests!\n");

    //The Rectangle tests
    Result rectangleResults = JUnitCore.runClasses(RectangleTest.class);
    System.out.println("The tests for the Rectangle class");
    for (Failure fail : rectangleResults.getFailures())
      System.out.println(fail);
    if (rectangleResults.wasSuccessful())
      System.out.println("Passed all the Rectangle tests!\n");

    //The Triangle tests
    Result triangleResults = JUnitCore.runClasses(TriangleTest.class);
    System.out.println("The tests for the Triangle class");
    for (Failure fail : triangleResults.getFailures())
      System.out.println(fail);
    if (triangleResults.wasSuccessful())
      System.out.println("Passed all the Triangle tests!\n");
    
    //The Parallelogram tests
    Result parallelogramResults = JUnitCore.runClasses(ParallelogramTest.class);
    System.out.println("The tests for the Parallelogram class");
    for (Failure fail : parallelogramResults.getFailures())
      System.out.println(fail);
    if (parallelogramResults.wasSuccessful())
      System.out.println("Passed all the Parallelogram tests!\n");
  }
}
