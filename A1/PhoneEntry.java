/**
 * PhoneEntry is a class that holds contact information like a phonebook
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
class PhoneEntry{

	/** The full name of the person */
	private String personName;
	
	/** The address of the person */
	private String address;

	/** The phoneNumber of the person */
	private String phoneNumber;


	/**
	 * Default constructor - creates an empty entry with fields set to safe states
	 */
	public PhoneEntry(){
		personName = null;
		address = null;
		phoneNumber = null;
	}

	/**
	 * 3 arg constructor - creates a phone entry with the specified values
	 * @param pName name of the person
	 * @param add address of the person
	 * @param pNum phone number of the person
	 */
	public PhoneEntry(String pName, String add, String pNum){

		personName = pName;
		address = add;
		phoneNumber = pNum;
	}


	@Override
	/**
	 * Override the default toString() method
	 * @return String This returns the string representation of a PhoneEntry
	 */
	public String toString(){

		return "Name: " + personName + " " +
			"Address: " + address + " " +
			"Phone Number: " + phoneNumber + "\n";
	}

	@Override
	
	/**
	 * Override the default equals() method
	 * Compares whether a object is equivalent to this PhoneEntry
	 * @param o Object that we are comparing the current object
	 * @return boolean True if it is equal, false otherwise
	 */
	public boolean equals(Object o){
		
		if (this == o) return true;
		if (!(o instanceof PhoneEntry)) return false;

		PhoneEntry p = (PhoneEntry) o;

		if (personName != p.personName) return false;
		if (address != p.address) return false;
		if (phoneNumber != p.phoneNumber) return false;

		return true;
	}

	@Override
	/**
	 * Override the default hashCode() method
	 * <p>
	 * As a practice when overriding equals() to have it to complete
	 * the general contract for the hashCode() method which states that 
	 * equal objects must have equal hash codes
	 * @return int a number that is attributed to this PhoneEntry based on
	 * its fields
	*/
	public int hashCode(){

		int result = 31 * (personName.hashCode() + address.hashCode() + 
			phoneNumber.hashCode());	

		return result;
	}

	//Getters and setters
	
	/**
	 * Gets the person's name
	 * @return String the person's name
	 */
	public String getPersonName(){
		return personName;
	}

	/**
	 * Sets the person's name
	 * @param name A value to be set to personName
	 * @return none
	 */
	public void setPersonName(String name){
		personName = name;
	}

	/**
	 * Gets the person's address
	 * @return String the person's address
	 */
	public String getAddress(){
		return address;
	}

	/**
	 * Sets the person's address
	 * @param address A value to be set to address
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * Get the person's phone number
	 * @return String the person's phone number
	 */
	public String getPhoneNumber(){
		return phoneNumber;
	}

	/**
	 * Set the person's phone number
	 * @param phone A value to be set to phoneNumber
	 */
	public void setPhoneNumber(String phone){
		phoneNumber = phone;
	}
}
