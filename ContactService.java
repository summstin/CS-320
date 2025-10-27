// Summer Stinnett
package milestone;

import java.util.List;
import java.util.ArrayList;

public class ContactService {

	public static List<Contact> contactList = new ArrayList<Contact>();
	
	public boolean idChecker(List<Contact> contactList, String contactIDToCheck) {
	for (Contact contact : contactList) {
        if (contact.getContactID() == contactIDToCheck) {
            return true; // ID found
        }
    }
    return false; // ID not found
}
	// add contact function
	public void addContact(Contact newContact) {
		//String contactID = UUID.randomUUID().toString().substring(0, 10);
		//Contact newContact = new Contact(firstName, lastName, number, address);
		if(newContact == null || !idChecker(contactList, newContact.getContactID()))
			contactList.add(newContact);
		else
			throw new IllegalArgumentException("Invalid contactID");
	}
	
	// delete contact function
	public void deleteContact(String contactID) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactID)
				contactList.remove(i);
			else
				throw new IllegalArgumentException("Invalid contactID. Does not exist.");
		}
	}
	// update contact function
	public void updateContact(String contactID, String firstName, String lastName, String number, String address) {
		for (Contact contactToUpdate : contactList) {
            if (contactToUpdate.getContactID().equals(contactID)) {
                contactToUpdate.setFirstName(firstName);
                contactToUpdate.setLastName(lastName);
                contactToUpdate.setNumber(number);
                contactToUpdate.setAddress(address);
			}
		}
	}
	
}
