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

    //The Shape tests
    Result circleResults = JUnitCore.runClasses(ShapeTests.class);
    System.out.println("The tests for all the Shape classes");
    for (Failure fail : circleResults.getFailures())
      System.out.println(fail);
    if (circleResults.wasSuccessful())
      System.out.println("Passed all the Shape tests!\n");
    
  }
}
