/**
 * CollegeStudent is a class that is a subclass of Student and holds additional 
 * information such as courses the student is enrolled in an overall final grade
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.catch
 * @version 1.0
 */
public class CollegeStudent extends Student implements Cloneable{

	/** Courses CollegeStudent is enrolled in. */
	private Course [] courses;

	/** Final letter grade of the CollegeStudent */
	private String finalGrade;

	/** 
	 * No argument constructor, sets the object to a safe state
	 */
	public CollegeStudent(){

		courses = null;
		finalGrade = "N/A";
	}

	/** 
	 * Multi arg constructor, creates the object with the passed in parameters
	 * <p>
	 * The constructor also makes use of a thread and a runnable object to calcuate
	 * the final letter grade of the CollegeStudent. 
	 * @param sName Student's Name
	 * @param sid Student's Id
	 * @param stName Street name of the Address
	 * @param stNum Street number of the Address
	 * @param town Town of the Address
	 * @param prov Province of the Address
	 * @param zipPara Zip code of the Address
	 * @param courses The courses the student is enrolled in
	 */
	public CollegeStudent(String sName, String sid, String stName, int stNum,
		String town, String prov, String zip, Course[] courses) {

		super(sName, sid, stName, stNum, town, prov, zip);
		
		try {
			System.out.println("Attempting CollegeStudent creation\nEntering "
					+ "course checker");
			CollegeChecker(courses);	
			this.courses = courses;

			//Create a runnable object that finds the final grade by 
			//invoking the grade function
			Runnable r1 = new Runnable(){

				public synchronized void run(){
					
					int totalmark = 0;
					int totalCourses = 0;

					for (int i = 0; i < courses.length && courses[i] != null; i++){
						totalmark += courses[i].getCourseMark();
						totalCourses++;
					}

					finalGrade = grade(totalmark / totalCourses);
					
				}
			};

			Thread t1 = new Thread(r1, "My grade thread");
			t1.start();

			System.out.println("CollegeStudent created");
		}
		catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}
		

	}

	/**Check function that checks if the number of courses is at least 3
	 * or it'll throw an exception.
	 * @param c An array of courses
	 * @exception IllegalArgumentException
	 */
	public void CollegeChecker(Course [] c){

		int count = 0;

		for (int i = 0; i < c.length; i++)
			if (c[i] != null) count++;

		if (count < 3){
			throw new IllegalArgumentException("Must have at least 3 courses\n");
		}
	}

	@Override
	/**
	 * Override the default toString() method
	 * @return String A String representation of the Student object
	 */
	public String toString(){

		String couString = "";
		for (int i = 0; i < courses.length && courses[i] != null; i++){
			couString += courses[i].toString() + "\n";
		}

		return "College Student\n" + super.toString() + couString + 
			"Final Grade: " + finalGrade + "\n"; 
	}

	@Override
	/**
	 * Override the default equals() method
	 * <p>
	 * Checks whether the passed in object is equal to the current CollegeStudent 
	 * object
	 * @param o The object to be compared to the current object
	 * @return boolean True if it is equal and false otherwise
	 */
	public boolean equals(Object o){

		if (this == o) return true;
		if (!(o instanceof CollegeStudent)) return false;

		CollegeStudent col = (CollegeStudent) o;
		if (!(super.equals( (Student) o) )) return false;
	
		if (courses.length != col.courses.length) return false;

		for (int i = 0; i < courses.length; i++){
			if (!(courses[i].equals(col.courses[i])))
				return false;
		}

		return true;
	}

	@Override
	/**
	 * Override the default hashCode() method
	 * <p>
	 * Produces a hashCode for the object
	 * @return int A number that is attributed to the current object
	 */
	public int hashCode(){

		int coursesHash = 0;
		for (int i = 0; i < courses.length && courses[i] != null; i++)
			coursesHash += courses[i].hashCode();

		int result = 31 * (super.hashCode() + coursesHash);

		return result;
	}

	@Override
	/**
	 * Override the default clone() method
	 * <p>
	 * Clones the current object and returns it
	 * @return Object The clone of the Object 
	 */
	protected Object clone() throws CloneNotSupportedException{

		Student studClone = (Student) super.clone();
		CollegeStudent colClone = (CollegeStudent) studClone;
		
		colClone.courses = new Course[courses.length];

		for (int i = 0; i < courses.length && courses[i] != null; i++)
			colClone.courses[i] = (Course) courses[i].clone();

		colClone.finalGrade = finalGrade;

		return colClone;
	}

	/**
	 * Testing main used to demonstrate a working  CollegeStudent class
	 * @param args Unused
	 * @return none
	 */
	public static void main(String[] args){
		
		//Create an array of courses
		Course[] cou1 = new Course[3];
		cou1[0] = new Course("c1", "cid1", "cdes1", new Book(), 55);
		cou1[1] = new Course("c2", "cid2", "cdes2", new Book(), 65);
		cou1[2] = new Course("c3", "cid3", "cdes3", new Book(), 75);

		//Create a CollegeStudent
		System.out.println("\nCollege student c:");
		CollegeStudent c = new CollegeStudent("sName1", "Sid1", "st1", 11,
			 	"Toronto", "ON", "M5G2H5", cou1);

		//Display the college student's contents
		System.out.println(c);

		//Create a 2nd array of courses
		Course[] cou2 = new Course[3];
		cou2[0] = new Course("c4", "cid4", "cdes4", new Book(), 85);
		cou2[1] = new Course("c5", "cid5", "cdes5", new Book(), 95);
		cou2[2] = new Course("c6", "cid6", "cdes6", new Book(), 85);

		//Create a 2nd CollegeStudent
		System.out.println("College student d:");
		CollegeStudent d = new CollegeStudent("sName2", "Sid2", "st2", 22,
				"Markham", "ON", "M4F2H8", cou2);

		//Display the 2nd CollegeStudent
		System.out.println(d);

		//Compare if c and d are equal -> should be false
		System.out.println("Are CollegeStudent c and d equal? " + c.equals(d));
		System.out.println("Hash of c: " + c.hashCode());
		System.out.println("Hash of d: " + d.hashCode() + "\n");

		//Let's try cloning CollegeStudent c
		System.out.println("Attempting to clone CollegeStudent c:");
		
		CollegeStudent cClone = new CollegeStudent();
		try {
			cClone = (CollegeStudent) c.clone();
		}
		catch (CloneNotSupportedException e){
			System.out.println("Caught a " + e.getMessage() + 
					" not cloned exception");
		}

		//Display the cloned CollegeStudent
		System.out.println("This is the cloned student cClone: " + cClone);
		System.out.println("Are c and the cClone equal? " + c.equals(cClone));
		System.out.println("Hash of c: " + c.hashCode());
		System.out.println("Hash of cClone: " + cClone.hashCode() + "\n");

		//Attempting to create a CollegeStudent with less than 3 courses
		System.out.println("Let's try making a CollegeStudent with less" 
				+ " than 3 courses");
		CollegeStudent e = new CollegeStudent("sName2", "Sid2", "st2", 22,
				"Markham", "ON", "M8J2J8", new Course [3]);
	}
}
