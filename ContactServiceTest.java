package milestone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ContactServiceTest {

	private ContactService service;
	
	@BeforeEach
    public void setUp() {
        service = new ContactService();
    }
	
    @Test
    public void testContactAddSuccess() {
        // Test successful creation of a contact
    	Contact contact = new Contact("Test", "Contact", "1111111111", "12345 Test Street"); 
    	service.addContact(contact);
        assertNotNull(contact);
    }

    @Test
    public void testContactAddFailureBecauseDuplicate() {
        // Test creation of a contact with invalid data
        assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("Test", "Contact", "1111111111", "12345 Test Street"); 
        	
        	//should not allow the same contact to be added
        	service.addContact(contact);
        	service.addContact(contact);
        });
    }
    
    @Test
    public void testContactDeleteFailure() {
        // Test creation of a contact with invalid data
        assertThrows(IllegalArgumentException.class, () -> {
        	service.deleteContact("NoIdsShouldExist");
        });
    }
       
    @Test
    public void testUpdateContactFailure() {
        // Test setting an invalid first name
    	Contact contact = new Contact("Test", "Contact", "1111111111", "12345 Test Street"); 
    	service.addContact(contact);
    	
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(contact.getContactID(), null, null, null, null);
        });
    }

}
