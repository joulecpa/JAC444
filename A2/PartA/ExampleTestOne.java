import static org.junit.Assert.*;
import org.junit.Test;
public class ExampleTestOne {
Example e = new Example();
@Test
 public void testAddString() {
assertEquals("Test for add(s1, s2): ", "Hello World", e.add("Hello", " JUnit"));
}
@Test
public void testAddInteger() {
assertEquals("Test for add(): ", 100, e.add());
}
@Test
public void testBuildString() {
Example e = new Example();
assertEquals("Test for buildString(): ", "121 + 13", e.buildString(3));
}
}
