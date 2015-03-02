/**
 * Course is a class that holds course information
 * <p>
 * Course has a clone function so it implements Clonable
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.catch
 * @version 1.0
 *
 */
public class Course implements Cloneable{

	/** The name of the course */
	private String courseName;

	/** The id of the course */
	private String courseId;

	/** A description of the course */
	private String courseDescription;

	/** The text book for the course, an instance of Book class */
	private Book courseText;

	/** The mark associated with the course */
	private int courseMark;

	/**
	 * No argument constructor, sets member variables to safe states
	 *
	 */
	public Course(){

		courseName = courseId = courseDescription = "";
		courseText = new Book();
		courseMark = -1;
	}

	/**
	 * 4 argument constructor, creates a course from the passed in parameters
	 * @param cn name of the Course
	 * @param cid id of the Course
	 * @param cdes Description of the Course
	 * @param b the book for the Course
	 * @param cm the mark associated with the Course
	 * @see clone
	 */
	public Course(String cn, String cid, String cdes, Book b, int cm){
		courseName = cn;
		courseId = cid;
		courseDescription = cdes;

		//Set the book by cloning it
		try {
			courseText = (Book) b.clone();
		}
		catch (CloneNotSupportedException e){
			System.out.println("Caught a " + e.getMessage() + 
					"not cloned exeception");
		}

		courseMark = cm;
	}

	/** 
	 * Getter for courseMark
	 * @return int returns the course Mark
	 *
	 */ 
	public int getCourseMark(){
		return courseMark;
	}

	@Override
	/**
	 * Override the default toString() method
	 * @return String This returns the string representation of a Course object
	 */
	public String toString(){

		return "Course\n Name: " + courseName + " Id: " + courseId + 
			" Description: " + courseDescription + "\n" + 
			courseText.toString() + "Course Mark: " + courseMark + "\n";
	}

	@Override
	/**
	 * Override the default equals() method
	 * Compares whether a object is equivalent to this Course
	 * @param o Object that is being compared to the current Course object
	 * @return boolean True if it is equal and false otherwise
	 */
	public boolean equals(Object o){

		if (this == o) return true;
		if (!(o instanceof Course)) return false;

		Course c = (Course) o;
		if (this.courseName != c.courseName) return false;
		if (this.courseId != c.courseId) return false;
		if (this.courseDescription != c.courseDescription) return false;
		if (!(courseText.equals(c.courseText))) return false;
		if (this.courseMark != c.courseMark) return false;

		return true;
	}

	@Override
	/**
	 * Override the default hashCode() method
	 * <p>
	 * Produces the hashCode for the object.
	 * @return int a number that is attributed to this Course based on
	 * its fields
	 */
	public int hashCode(){

		int result = 31 * (courseName.hashCode() + courseId.hashCode() + 
				courseDescription.hashCode() + courseText.hashCode() + courseMark);

		return result;
	}

	@Override
	/**
	 * Override the default clone method
	 * <p> 
	 * This function creates a clone of the current object and returns it
	 * @exception CloneNotSupportedException
	 * @return Object The cloned Course Object
	 * @see clone
	 */
	protected Object clone() throws CloneNotSupportedException{

		Course c = (Course) super.clone();
		c.courseText = (Book) courseText.clone();
		return c;
	}

	/**
	 * Testing main function used to demonstrate a working Course class
	 * @param args Unused
	 * @return none
	 */
	public static void main(String[] args){


		//Create a Book with some values
		Book a = new Book("Book1", "ISBN1", 20.20);

		//Create a Course with some values + book a as the course text
		Course cou1 = new Course("CouName1", "CouId1", "CouDes1", a, 60);

		//Display the course's contents via toString
		System.out.println(cou1);

		//Create a 2nd Book and a 2nd Course with that Book
		Book b = new Book("Book2", "ISBN2", 30.30);
		Course cou2 = new Course("CouName2", "CouId2", "CouDes2", b, 70);

		//Display the 2nd course's contents
		System.out.println(cou2);

		//Comparing cou1 and cou2 to see if they're equal -> should be false
		System.out.println("Are cou1 and cou2 equal?" + cou1.equals(cou2));

		//Check the hashCodes of cou1 and cou2
		System.out.println("Are the hashcodes the same?");
		System.out.println("cou1 hash: " + cou1.hashCode());
		System.out.println("cou2 hash: " + cou2.hashCode() + "\n");


		//Try cloning with cou1
		Course cloneCou = new Course();

		try {
			System.out.println("Attempting to clone cou1");
			cloneCou = (Course) cou1.clone();
		}
		catch (CloneNotSupportedException e){
			System.out.println("Caught a " + e.getMessage() + 
					" cloning exeception");
		}

		//Lets compare the original cou1 with the cloned cloneCou
		System.out.println("Comparing cou1 with cloneCou:");
		System.out.println("Are cou1 and cloneCou equal? " + 
				cou1.equals(cloneCou));

		System.out.println("Hashcode of cou1: " + cou1.hashCode());
		System.out.println("Hashcode of cloneCou: " + cloneCou.hashCode());
		

	}

	
}
