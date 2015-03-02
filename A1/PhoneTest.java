/**
 * PhoneTest is a class that is just used for testing 
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class PhoneTest{

	/**
	 * Test main tests all of the PhoneEntry and PhoneBook classes
	 * @param args is unused
	 */
	public static void main(String[] args){

		System.out.println("Creating a phonebook: \n");

		//Create a phonebook with 10 spaces
		PhoneBook p = new PhoneBook("Toronto", 10);

		System.out.println("Adding 5 entries into the phonebook: \n");
		//Add the 5 entries
		p.add(new PhoneEntry("Person1", "Street1", "Phone1"));
		p.add(new PhoneEntry("Person2", "Street2", "Phone2"));
		p.add(new PhoneEntry("Person3", "Street3", "Phone3"));
		p.add(new PhoneEntry("Person4", "Street4", "Phone4"));
		p.add(new PhoneEntry("Person5", "Street5", "Phone5"));

		//Display the phonebook and its entries
		System.out.println(p);

		System.out.println("Deleting two entries from the phonebook: \n");
		//Deleting 2 entries
		p.deleteByName("Person1");
		p.deleteByName("Person2");

		/* attempt deleting more than 2, and deleting when the phonebook is empty
		p.deleteByName("Person3");
		p.deleteByName("Person4");
		p.deleteByName("Person5");

		//No more entries -> will print null
		System.out.println(p.deleteByName("Unknown entry"));
		*/

		System.out.println("Post delete\n");

		//Display the phonebook and its entries
		System.out.println(p);
	}
}
