import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
 * It will implement four methods (along with toString, equals, hashCode and clone overrides)
 * getPerimeter, getArea, getPerimeterMax and getAreaMin. The former two will get the
 * the total perimeter and area of all the Shapes in the Picture through the use of
 * lambda expressions. The latter two return the respective max or min value of all the 
 * shapes in the Picture (these values are also calcuated in getPerimeter and getArea). 
 * It will also run each of the perimeter and area operations in a thread. Additionally 
 * there is added functionality that allows for reading input of a Picture's shapes 
 * from a text file.
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.1
 */
public class Picture implements Cloneable{

  /** The Shapes in the picture. */
  ArrayList<Shape> shapes;  

  /** The total perimeter of the Picture */
  double totalPerimeter;

  /** The total area of the Picture */
  double totalArea;

  /** The largest perimeter of all the shapes in the Picture */
  double maxPerimeter;

  /** The smallest area of all the shapes in the Picture */
  double minArea;

  /**
   * No argument constructor, initalizes the fields to safe states.
   */
  Picture(){
    shapes = new ArrayList<Shape>();
    totalPerimeter = 0;
    totalArea = 0;
    maxPerimeter = 0;
    minArea = 0;
  }

  /**
   * Default one argument constructor, initalizes the Shape ArrayList to the passed in value
   * and the other fields to safe states.
   * @param s An array of shapes that compose the Picture.
   */
  Picture(ArrayList<Shape> s){
    shapes = s;
    totalPerimeter = 0;
    totalArea = 0;
    maxPerimeter = 0;
    minArea = 0;
  }

  /**
   * Secondary one argument constructor that takes in a String filename.
   * <p>
   * The shapes array will be built using the contents of the text file which bears the name
   * passed in through this constructor. Makes use of scanner to parse the text file.
   * @param filename The name of the file that will be used to initalizes the shape ArrayList
   */
  Picture(String filename) throws IOException{
    shapes = new ArrayList<Shape>();
    
    File f = new File(filename);    
    
    Scanner scanline = new Scanner(f);
    double a, b ,c;
      
    while (scanline.hasNextLine()){
      //Using nested Scanners to read the tokens of a particular line
      Scanner scantoken = new Scanner(scanline.nextLine());
      
      if (!scantoken.hasNext()) //Empty line so we stop parsing the file
        break;

      while (scantoken.hasNext()){

        String tmp = scantoken.next();
        tmp = tmp.toLowerCase(); //Bypass any issue of lower/uppercase in text file
        switch (tmp){
          case "circle":
            a = scantoken.nextDouble();
            shapes.add(new Circle(a));
            break;
          case "square":
            a = scantoken.nextDouble();
            shapes.add(new Square(a));
            break;
          case "rectangle":
            a = scantoken.nextDouble();
            b = scantoken.nextDouble();
            shapes.add(new Rectangle(a, b));
            break;
          case "triangle":
            a = scantoken.nextDouble();
            b = scantoken.nextDouble();
            c = scantoken.nextDouble();
            shapes.add(new Triangle(a, b,c ));
            break;
          case "parallelogram":
            a = scantoken.nextDouble();
            b = scantoken.nextDouble();
            c = scantoken.nextDouble();
            shapes.add(new Parallelogram(a, b,c ));
            break;
          default:
            System.out.println("There is no support for this shape.");
        }

      } //Nested while
    } //Outer while

    totalPerimeter = 0;
    totalArea = 0;
    maxPerimeter = 0;
    minArea = 0;
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
   * Makes use of lambda expressions and threads. Also finds the value of maxPerimeter.
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
            double temp = 0;

            switch (shapeType){
              case "Circle":
                temp += circle.getPerimeter((Circle) s);
                break;
              case "Square":
                temp += square.getPerimeter((Square) s);
                break;
              case "Rectangle":
                temp += rect.getPerimeter((Rectangle) s);
                break;
              case "Triangle":
                temp += tri.getPerimeter((Triangle) s);
                break;
              case "Parallelogram":
                temp += para.getPerimeter((Parallelogram) s);
                break;
              default:
                System.out.println(shapeType + " is not supported by this program.");
            }
            
            totalPerimeter += temp;
            if (maxPerimeter == 0) maxPerimeter = temp; //Find the maxPerimeter
            else maxPerimeter = maxPerimeter < temp ? temp : maxPerimeter;
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
   * Makes use of lambda expressions and threads. Also finds the value of minArea.
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
            double temp = 0;
            
            switch (shapeType){ //synchronize the relevant resource
              case "Circle":
                temp += circle.getArea((Circle) s);
                break;
              case "Square":
                temp += square.getArea((Square) s);
                break;
              case "Rectangle":
                temp += rect.getArea((Rectangle) s);
                break;
              case "Triangle":
                temp += tri.getArea((Triangle) s);
                break;
              case "Parallelogram":
                temp += para.getArea((Parallelogram) s);
                break;
              default:
                System.out.println(shapeType + " is not supported by this program.");
            }
          
            totalArea += temp;
            if (minArea == 0) minArea = temp; //Find the minArea
            else minArea = minArea > temp ? temp : minArea;
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

  /**
   * Gets the largest perimeter of all the shapes in the Picture
   * @return double The largest perimeter.
   */
  public double getPerimeterMax(){
    getPerimeter();
    return maxPerimeter;
  }


  /**
   * Gets the smallest area of all the shapes in the Picture
   * @return double The smallest area
   */
  public double getAreaMin(){
    getArea();
    return minArea;
  } 
}
