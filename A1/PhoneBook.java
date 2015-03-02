/**
 * PhoneBook is a class that holds phoneEntries
 *
 * @author Hong Zhan Huang hzhuang3@myseneca.ca
 * @version 1.0
 */
public class PhoneBook{

	/** The city that the phonebook is attributed to */
	private String city;
	/** The total number of phoneEntries in the phonebook */
	private int totalEntries;

	/** Used to keep track of current index in the array of phone entries */
	private int newestEntry;
	/** Array of PhoneEntry objects that store the phonebook's entries */
	private PhoneEntry[] phoneEntries;

	/**
	 * Default Constructor, sets values to a safe/default states
	 */
	public PhoneBook(){

		city = "Markham";
		totalEntries = 10000;
		phoneEntries = new PhoneEntry[totalEntries];
		newestEntry = 0;
	}

	/**
	 * 2 arg Constructor - creates a PhoneBook with the specified values
	 * <p>
	 * Sets the city, totalEntries and allocates the memory for the
	 * phoneEntries.
	 * @param city The city's name
	 * @param totalEntries The max number of entries for the phonebook
	 */ 
	public PhoneBook(String city, int totalEntries){
		this.city = city;
		this.totalEntries = totalEntries;
		phoneEntries = new PhoneEntry[totalEntries];
		newestEntry = 0;
	}


	
	/**
	 * Add entries into the PhoneBook
	 * @param entry The entry to be added to the phone book
	 * @return boolean true if it was successfully add and false otherwise
	 */
	public boolean add(PhoneEntry entry){
	
		if (newestEntry == 0){
			phoneEntries[newestEntry] = entry;
			newestEntry++;
			return true;
		}

		if (newestEntry + 1 > totalEntries)
			return false;
		else{
			phoneEntries[newestEntry] = entry;
			newestEntry++;
			return true;
		}
	}

	/**
	 * Deletes any entries with city = name
	 * @param name the name of the entry to be deleted
	 * @return PhoneEntry[] a array of the deleted Entries
	 */
	public PhoneEntry[] deleteByName(String name){

		PhoneEntry[] del = new PhoneEntry[newestEntry];
		PhoneEntry[] temp = new PhoneEntry[newestEntry];

		int indexDel, indexTemp;
		indexDel = indexTemp = 0;
		for (int i = 0; i < newestEntry; i++){
		
			if (phoneEntries[i].getPersonName() == name){
				del[indexDel] = phoneEntries[i];
				indexDel++;
			}
			else{
				temp[indexTemp] = phoneEntries[i];
				indexTemp++;
			}
		}

		//Entries have been deleted and phoneEntries is assigned temp, the
		//resorted array of entries. Adjust the newestEntry index by the amount
		//of deleted entries.
		if (indexDel > 0){
			phoneEntries = temp;
			newestEntry -= indexDel;
			return del;
		}

		//Nothing was deleted
		return null;
	}

	/**
	 * Return a string representation of the phonebook's contents
	 * @return String String representation of the phonebook
	 */
	public String toString(){

		String ret = "";

		ret += "This phonebook's city is " + city + " and there are " +
			newestEntry + " entries in it currently.\n" + 
			"The entries are as follows:\n";

		for (int i = 0; phoneEntries[i] != null; i++)
			ret += phoneEntries[i].toString();

		return ret;
	}
}
