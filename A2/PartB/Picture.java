import java.util.ArrayList;

/**
 * Simple custom thread class to supplement multithreading with the getPerimeter and
 * getArea methods.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
class MyThread extends Thread{

  private Thread t;
  private String ThreadName;
}

/**
 * Functional interface for use with implementing lambdas in the Picture class
 */
interface Perimeter<T>{
  double getPerimeter(T s);
}

/**
 * Functional interface for use with implementing lambdas in the Picture class
 */
interface Area<T>{
  double getArea(T s);
}

/**
 * The Picture class holds instances of the Shape class.
 * <p>
 * It will implment two methods getPerimeter and getArea which will get the
 * the total perimeter and area of all the Shapes in the Picture through the use of
 * lambda expressions. It will also run each of the perimeter and area operations in a
 * thread.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Picture implements Cloneable{

  /** The Shapes in the picture. */
  ArrayList<Shape> shapes;

  /** The total perimeter of the Picture */
  double totalPerimeter;

  /** The total area of the Picture */
  double totalArea;

  /**
   * No argument constructor, initalizes the fields to safe states
   */
  Picture(){
    shapes = new ArrayList<Shape>();
    totalPerimeter = 0;
    totalArea = 0;
  }

  /**
   * One argument constructor, initalizes the Shape array to the passed in value
   * and the other fields to safe states.
   * @param s The array of shapes that compose the Picture.
   */
  Picture(ArrayList<Shape> s){
    shapes = s;
    totalPerimeter = 0;
    totalArea = 0;
  }

  @Override
  /**
   * toString returns the string representation of the Picture.
   * <p>
   * The string representation of the Picture will be the returns of the toString method
   * of every Shape in the Picture.
   * @return String The string representation of the Picture.
   */
  public String toString(){

    String ret = "";
    for (Shape s : shapes)
      ret += s.toString();

    return ret;
  }

  @Override
  /**
   * equals compares the current object with the passed in object for equivalency
   * @return boolean True if they are equal and false otherwise.
   */
  public boolean equals(Object o){

    if (this == o) return true;
    if (!(o instanceof Picture)) return false;

    Picture p = (Picture) o;
    if (shapes != p.shapes) return false;

    return true;
  }

  @Override
  /**
   * Dummy hashCode for the purpose of supressing warnings.
   * @return int Returns 0.
   */
  public int hashCode(){

    return 0;
  }

  @Override
  /**
   * clone will create a clone of the current Picture object.
   * @exception CloneNotSupportedException
   * @return Object The clone of the current Picture object.
   */
  protected Object clone() throws CloneNotSupportedException{
    Picture p = (Picture) super.clone();
    for (Shape s : shapes)
      p.shapes.add(s);
    
    return p;
  }

  /**
   * getPerimeter will get the sum of all the perimeters of the Shapes in the Picture.
   * <p>
   * Makes use of lambda expressions and threads.
   * @return double The sum of the perimeter of all Shapes belonging to the Picture.
   */
  public double getPerimeter(){

    totalPerimeter = 0;
    
    Perimeter<Circle> circle = s -> s.radius * Math.PI * 2;
    Perimeter<Square> square = s -> s.length * 4;
    Perimeter<Rectangle> rect = s -> (s.length * 2) + (s.width * 2);
    Perimeter<Triangle> tri = s -> s.side_a + s.side_b + s.side_c;
    Perimeter<Parallelogram> para = s -> (s.length * 2) + (s.width * 2);
   
    for (Shape s : shapes){

      String shapeType = s.getClass().getSimpleName();

      MyThread t = new MyThread(){ //Run the perimeter operation in a thread

        public void run(){
          synchronized(shapes){ //synchronize the relevant resource
            switch (shapeType){
              case "Circle":
                totalPerimeter += circle.getPerimeter((Circle) s);
                break;
              case "Square":
                totalPerimeter += square.getPerimeter((Square) s);
                break;
              case "Rectangle":
                totalPerimeter += rect.getPerimeter((Rectangle) s);
                break;
              case "Triangle":
                totalPerimeter += tri.getPerimeter((Triangle) s);
                break;
              case "Parallelogram":
                totalPerimeter += para.getPerimeter((Parallelogram) s);
                break;
              default:
                System.out.println(shapeType + " is not supported by this program.");
            }

          }
        }

      };

      t.start();

      try {
         t.join(); //join the threads as they complete
      } catch( Exception e) {
         System.out.println("Interrupted");
      }


    }

    return totalPerimeter;
  }

  /**
   * getArea will get the sum of all the areas of the Shapes in the Picture.
   * <p>
   * Makes use of lambda expressions and threads.
   * @return double The sum of the area of all Shapes belonging to the Picture.
   */
  public double getArea(){

    totalArea = 0;

    Area<Circle> circle = s -> s.radius * s.radius * Math.PI;
    Area<Square> square = s -> s.length * s.length;
    Area<Rectangle> rect = s -> s.length * s.width;
    Area<Triangle> tri = s -> {
      double sp = (s.side_a + s.side_b + s.side_c) / 2; //Semi perimeter
      return Math.sqrt(sp * (sp - s.side_a) * (sp - s.side_b) * (sp - s.side_c));
    };
    Area<Parallelogram> para = s -> s.length * s.height;


    for (Shape s : shapes){

      String shapeType = s.getClass().getSimpleName();

      MyThread t = new MyThread(){ //Run the area operations in a thread
        
        public void run(){
          synchronized(shapes){
            switch (shapeType){ //synchronize the relevant resource
              case "Circle":
                totalArea += circle.getArea((Circle) s);
                break;
              case "Square":
                totalArea += square.getArea((Square) s);
                break;
              case "Rectangle":
                totalArea += rect.getArea((Rectangle) s);
                break;
              case "Triangle":
                totalArea += tri.getArea((Triangle) s);
                break;
              case "Parallelogram":
                totalArea += para.getArea((Parallelogram) s);
                break;
              default:
                System.out.println(shapeType + " is not supported by this program.");
            }
          }
        }

      };

      t.start();
      try {
         t.join(); //join the threads as they complete
      } catch( Exception e) {
         System.out.println("Interrupted");
      }


    }

    return totalArea;

  }
}
