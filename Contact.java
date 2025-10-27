// Summer Stinnett
package milestone;

import java.util.UUID;

public class Contact {
	
	// contact class properties
	private final String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	//constructor
	public Contact(String firstName, String lastName, String number, String address) {
		String contactID = UUID.randomUUID().toString().substring(0, 10);
		if (contactID == null || contactID == "" || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID input, try again.");
		}
		this.contactID = contactID;
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
	}
	
	// getters and setters
	public String getContactID() {
		return this.contactID;
	}
	public void setContactID(String contactID) {
		
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		if (firstName == null || firstName == "" || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name input, try again.");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName == "" || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name input, try again.");
		}
		this.lastName = lastName;
	}
		
	public String getNumber() {
		return this.number;

	}
	public void setNumber(String number) {
		if (number == null || number == "" || number.length() != 10) {
			throw new IllegalArgumentException("Invalid number input, try again.");
		}
		this.number = number;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		if (address == null || address == "" || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address input, try again.");
		}
		this.address = address;
	}
	

}
