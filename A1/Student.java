/**
 * Gradable is an interface that has the grade method.
 */
interface Gradable{

	/** 
	 * grade is a method that would be implemented to calcuate
	 * the letter grade when given a particular marks
	 * @param marks The number mark to be translated into letter grade
	 * @return String The letter grade
	 */
	String grade(int marks);
}

/**
 * ZipInter is a trivial interface with getter and setter methods
 * for the purpose of applying the concept of Anonymous classes  
 */
interface ZipInter{

	/**
	 * When implemented it will get the zip code
	 * @return String The zip code
	 */
	String getZip();

	/**
	 * When implemented it will set the zip code with the passed in parameter
	 * @param zip The string to be set as the zip code
	 */
	void setZip(String zip);
}


/**
 * Student is a class that represents the information about a particular student
 * <p>
 * It implements the Gradeable interface so it can calculate a Student's finally
 * grade and the Cloneable interface for the clone function
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class Student implements Gradable, Cloneable{

	/**
	 * Address is an inner class of Student and it is represents information about
	 * a particular Address
	 * <p>
	 * It implements Cloneable interface for the clone function
	 */
	class Address implements Cloneable{

		/** The name of the street of the Address*/
		private String streetName;

		/** The street number of the Address*/
		private int streetNum;

		/** The town of the Address */
		private String town;

		/** The province of the Address*/
		private String province;
		
		/** 
		 * Anonymous class for zip code using the ZipInter interface
		 */
		ZipInter zip = new ZipInter(){

			/** The 'member variable' zip code */
			String zipCode = "";

			/** 
			 * This method gets the zip code
			 * @return String The zip code
			 */
			public String getZip(){
				return zipCode;
			}

			/**
			 * This method sets the zip code
			 * @param zip Sets the zip code to this value
			 */
			public void setZip(String zip){
				zipCode = zip;
			}
		};

		/**
		 * No argument constructor, sets the Address object to a safe states
		 */
		public Address(){

			streetName = town = province = "";
			streetNum = 0;
			zip.setZip("");
		}

		/**
		 * 5 argument constructor
		 * Creates a Address object based on the passed in parameters
		 * @param stName Name of the street of Address
		 * @param stNum Street number of the Address
		 * @param town Town of the Address
		 * @param prov Province of the Address
		 * @param zipPara The zip code of the address
		 */
		public Address(String stName, int stNum, String town, String prov, 
			 String zipPara){

			streetName = stName;
			streetNum = stNum;
			this.town = town;
			province = prov;

			zip.setZip(zipPara);
		}

		@Override
		/**
		 * Override the default toString() method
		 * @return String The String representation of the Address object
		 */
		public String toString(){
			
			return "Address\n" + streetNum + " " + streetName + " " + town + " " +
				province + " " + zip.getZip() + "\n"; 
		}

		@Override
		/**
		 * Override the default equals() method
		 * <p>
		 * Compares whether a object is equal to the current Address object
		 * @param o The object to be compared to the current object
		 * @return boolean True if it is equal and false otherwise 
		 */
		public boolean equals(Object o){
		
			if (this == o) return true;
			if (!(o instanceof Address)) return false;

			Address a = (Address) o;
			if (streetName != a.streetName) return false;
			if (streetNum != a.streetNum) return false;
			if (town != a.town) return false;
			if (province != a.province) return false;
			if (zip.getZip() != a.zip.getZip()) return false;

			return true;
		}

		@Override
		/**
		 * Override the default hashCode() method
		 * <p>
		 * Produces the hashCode for the object
		 * @return int A number that is attributed to the current object based on its
		 * fields 
		 */
		public int hashCode(){

			int result = 31 * (streetName.hashCode() + streetNum + town.hashCode() +
				 	province.hashCode() + zip.getZip().hashCode());

			return result;
		}

		@Override
		/**
		 * Override the default clone() method
		 * <p>
		 * This function creates a clone of the current Address object and returns it
		 * @exception CloneNotSupportedException
		 * @return Object The clone of the current object
		 */
		protected Object clone() throws CloneNotSupportedException{

			Address a = (Address) super.clone();
			return a;
		}
	}
	//------------------------End of Address class

	/** The student's name */
	private String studName;

	/** The student's id */
	private String studId;

	/** The student's Address */
	private Address studAdd;

	/**
	 * No argument constructor, sets the object to a safe state
	 */
	public Student(){

		studName = studId = "";
		studAdd = new Address();
	}

	/**
	 * Multi arg constructor, creates a Student from the passed in parameters
	 * @param sName Student's Name
	 * @param sid Student's Id
	 * @param stName Street name of the Address
	 * @param stNum Street number of the Address
	 * @param town Town of the Address
	 * @param prov Province of the Address
	 * @param zipPara Zip code of the Address
	 */
	public Student(String sName, String sid, String stName, int stNum,
			String town, String prov, String zipPara){

		studName = sName;
		studId = sid;

		studAdd = new Address(stName, stNum, town, prov, zipPara);
	}

	@Override
	/**
	 * Override the default toString() method
	 * @return String A String representation of the Student object
	 */
	public String toString(){

		return "Student\n Name: " + studName + " Id: " + studId + "\n" 
			+ studAdd.toString();
	}

	@Override
	/**
	 * Override the default equals() method
	 * <p>
	 * Checks whether the passed in object is equal to the current Student object
	 * @param o The object to be compared to the current object
	 * @return boolean True if it is equal and false otherwise
	 */
	public boolean equals(Object o){
		
		if (this == o) return true;
		if (!(o instanceof Student)) return false;

		Student s = (Student) o;
		if (studName != s.studName) return false;
		if (studId != s.studId) return false;

		if (!(studAdd.equals(s.studAdd))) return false;

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

		int result = 31 * (studName.hashCode() + studId.hashCode() 
				+ studAdd.hashCode());

		return result;
	}

	@Override
	/**
	 * Override the default clone() method
	 * <p>
	 * Clones the current object and returns it
	 * @exception CloneNotSupportedException
	 * @return Object The clone of the Object 
	 */
	protected Object clone() throws CloneNotSupportedException{

		Student s = (Student) super.clone();
		s.studAdd = (Address) studAdd.clone();
		return s;
	}

	@Override

	/**
	 * Implement the Gradeable interface's grade function
	 * @param marks The number mark to be translated to letter grade
	 * @return String The final letter grade
	 */
	public String grade(int marks){
		
		if (marks > 100 || marks < 0)
			return "Invalid mark";

		if (marks >= 80)
			return "A";
		else if (marks >= 70)
			return "B";
		else if (marks >= 60)
			return "C";
		else if (marks >= 50)
			return "D";
		else
			return "F";
			
	}

	/**
	 * Testing main used to demonstrate a working Address, Zip and Student class
	 * @param args Unused
	 * @return none
	 */
	public static void main(String[] args){

		//Let's test if Student (and Address) works properly
		
		//Create a student with some student and address releated values
		Student s = new Student("Stu1", "Sid1", "StName1", 11, "Toronto", "ON",
			"M5G 2H1"	);

		//Display the contents of the student
		System.out.println("This is student s: \n" + s);

		//Create a 2nd student
		Student t = new Student("Stu2", "Sid2", "StName2", 22, "Toronto", "ON",
			"M5G 2H2");

		//Display the contents
		System.out.println("This is student t: \n" + t);

		//Let's compare their equivalance -> should be false
		System.out.println("Are student s and t equal? " + s.equals(t));

		//Let's check their hash codes
		System.out.println("Hash of student s: " + s.hashCode());
		System.out.println("Hash of student t: " + t.hashCode() + "\n");

		//Attempt to make a clone of student s
		System.out.println("Attemping to clone student s:");
		Student sClone = new Student();
		
		try {
			sClone = (Student) s.clone();
		}
		catch (CloneNotSupportedException e){
			System.out.println("Caught a " + e.getMessage() + 
					" not cloned exeception");
		}

		System.out.println("This is the clone of student s:\n" + sClone);

		//Let's check if the clone and the original are equal
		System.out.println("Are s and sClone equal? " + s.equals(sClone));
		System.out.println("Hash of student s: " + s.hashCode());
		System.out.println("Hash of student sClone: " + sClone.hashCode() + "\n");
	
		//Finally let's try out the grade function
		System.out.println("Testing out the grade function:\n");
		System.out.println("If the mark is 100 then the grade is: " + s.grade(100));
		System.out.println("If the mark is 80 then the grade is: " + s.grade(80));
		System.out.println("If the mark is 70 then the grade is: " + s.grade(70));
		System.out.println("If the mark is 60 then the grade is: " + s.grade(60));
		System.out.println("If the mark is 50 then the grade is: " + s.grade(50));
		System.out.println("If the mark is 0 then the grade is: " + s.grade(0));

			
		System.out.println("If the mark is 101 then the grade is: " + s.grade(101));
		System.out.println("If the mark is -1 then the grade is: " + s.grade(-1));
		
	}
}
