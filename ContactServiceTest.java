import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("123", "John", "Smith", "1234567890", "123 Main Street");
    }

    @Test
    public void testAddContact() {
        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("123"));
    }

    @Test
    public void testCannotAddDuplicateContactID() {
        Contact duplicate = new Contact("123", "Jane", "Doe", "0987654321", "456 Oak Street");

        assertTrue(service.addContact(contact));
        assertFalse(service.addContact(duplicate));
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);

        assertTrue(service.deleteContact("123"));
        assertNull(service.getContact("123"));
    }

    @Test
    public void testDeleteContactThatDoesNotExist() {
        assertFalse(service.deleteContact("999"));
    }

    @Test
    public void testUpdateFirstName() {
        service.addContact(contact);

        assertTrue(service.updateFirstName("123", "Mike"));
        assertEquals("Mike", service.getContact("123").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        service.addContact(contact);

        assertTrue(service.updateLastName("123", "Jones"));
        assertEquals("Jones", service.getContact("123").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        service.addContact(contact);

        assertTrue(service.updatePhone("123", "0987654321"));
        assertEquals("0987654321", service.getContact("123").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        service.addContact(contact);

        assertTrue(service.updateAddress("123", "456 Oak Street"));
        assertEquals("456 Oak Street", service.getContact("123").getAddress());
    }

    @Test
    public void testUpdateContactThatDoesNotExist() {
        assertFalse(service.updateFirstName("999", "Mike"));
        assertFalse(service.updateLastName("999", "Jones"));
        assertFalse(service.updatePhone("999", "0987654321"));
        assertFalse(service.updateAddress("999", "456 Oak Street"));
    }
}
