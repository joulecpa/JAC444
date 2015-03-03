import org.junit.runner.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
public class RunExampleTests {
public static void main(String[] args) {
//the first test results
Result result1 = JUnitCore.runClasses(ExampleTestOne.class);
System.out.print("The FIRST Test Results ");
for (Failure failure : result1.getFailures())
System.out.println(failure);
if (result1.wasSuccessful())
System.out.println("Tests finished successfully !");
//the second test results
Result result2 = JUnitCore.runClasses(ExampleTestTwo.class);
System.out.print("\n\nThe SECOND Test Results ");
for (Failure failure : result2.getFailures())
System.out.println(failure);
if (result2.wasSuccessful())
System.out.println("Tests finished successfully !");
}
}
