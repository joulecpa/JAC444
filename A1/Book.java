/**
 * Book is a class that holds information about a Book
 * <p>
 * Course has a clone function so it implements Clonable
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.catch
 * @version 1.0
 */
public class Book implements Cloneable{

	/** The name of the book */
	private String bookName;

	/** The book's ISBN */
	private String bookISBN;

	/** The price of the book */
	private double bookPrice;


	/**
	 * No argument constructor, sets the member variables to a safe states
	 */
	public Book(){
		bookName = bookISBN = "";
		bookPrice = 0;
	}

	/** 
	 * 3 argument constructor, creates a Book from the passed in parameters
	 * @param bn The name of the Book
	 * @param bi The ISBN of the Book
	 * @param bp The price of the Book
	 */
	public Book(String bn, String bi, double bp){

		bookName = bn;
		bookISBN = bi;
		bookPrice = bp;
	}

	@Override
	/**
	 * Override the default toString() method
	 * @return String This returns the string representation of a Book object
	 */
	public String toString(){

		return "Text Book\n Name: " + bookName + " ISBN: " + bookISBN + " Price: " +
		 bookPrice + "\n";	
	}

	@Override
	/**
	 * Override the default equals() method
	 * Compares whether an object is equal to the current Book object
	 * @param o The object to be compared to the current Book object
	 * @return boolean True if it is equal and false otherwise
	 */
	public boolean equals(Object o){

		if (this == o) return true;
	 	if (!(o instanceof Book)) return false;

		Book b = (Book) o;
		if (bookName != b.bookName) return false;
		if (bookISBN != b.bookISBN) return false;
		if (bookPrice != b.bookPrice) return false;
		
		return true;	
	}

	@Override
	/**
	 * Override the default hashCode() method
	 * <p>
	 * Produces the hashCode for the object
	 * @return int a number that is attributed to this Book object based on its 
	 * fields
	 */
	public int hashCode(){
		
		int result = 31 * (bookName.hashCode() + bookISBN.hashCode() + 
				(int) bookPrice);

		return result;
	}

	@Override
	/**
	 * Override the default clone() method
	 * <p>
	 * This function creates a clone of the current object and returns it
	 * @exception CloneNotSupportedException
	 * @return Object The cloned Book object
	 * @see clone
	 */
	protected Object clone() throws CloneNotSupportedException{
		Book b = (Book) super.clone();
		return b;
	}


	/** 
	 * Testing main used to demonstrate a workng Book class
	 * @param args Unused
	 * @return none
	 */
	public static void main(String[] args){

		//Create a Book with some values
		Book a = new Book("Book1", "ISBN1", 20.20);

		//Display the book's contents via toString()
		System.out.println(a);

		//Create a 2nd book with some different values
		Book b = new Book("Book2", "ISBN2", 30.30);

		//Display 2nd book's contents
		System.out.println(b);

		//Attempt equals() function between book a and b
		//the result should be false
		System.out.println("Comparing book a and b:");
		System.out.println("Are they equal? " + a.equals(b));

		//Check the hashcodes of a and b, they should be different
		System.out.println("This is the hash of book a: " + a.hashCode());
		System.out.println("This is the hash of book b: " + b.hashCode() + "\n");

		Book c = new Book();

		//Let's try cloning with book a
		try{
			System.out.println("Attemping to clone book a into a new book c:");
			c = (Book) a.clone();
			System.out.println(c);
		}
		catch (CloneNotSupportedException e){

			System.out.println("Caught a " + e.getMessage() + 
					"not cloned exeception");
		}

		//Let's compare the clone c with the original a and see if they're the same
		System.out.println("Comparing book c to a:");
		System.out.println("Are they equal? " + c.equals(a));
		System.out.println("This is the hash of book c: " + c.hashCode());
		System.out.println("This is the hash of book a: " + a.hashCode() + "\n");

	}

}

