package milestone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
    public void testContactCreationSuccess() {
        // Test successful creation of a contact
        Contact contact = new Contact("Test", "Contact", "1111111111", "12345 Test Street");    
        assertTrue(contact.getContactID() != null || contact.getContactID() != "" || contact.getContactID().length() <= 10);
    }
	
	@Test
	void testContactFirstNameWithMoreThanTenCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("TestFirstNameMoreThanTen", "LastName", "1111111111", "12345 Test Street");
        });
	}

	@Test
	void testContactLastNameWithMoreThanTenCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test", "ContactLastNameMoreThanTen", "1111111111", "12345 Test Street");
        });
	}

	@Test
	void testContactPhoneNumberWithMoreThanTenCharacters() {	
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test", "Contact", "1111111111000", "12345 Test Street");
        });
	}

	@Test
	void testContactAddressWithMoreThanThirtyCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test", "Contact", "1111111111", "This address has more than 30 characters.");
        });
	}

	@Test
	void testContactFirstNameNull() {		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Contact", "1111111111", "12345 Test Street");
		});
	}

	@Test
	void testContactLastNameNull() {		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test", null, "1111111111", "12345 Test Street");
		});
	}

	@Test
	void testContactPhoneNull() {	
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test", "Contact", null, "12345 Test Street");
		});
	}

	@Test
	void testContactAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Test", "Contact", "1111111111", null);
		});
	}
}
