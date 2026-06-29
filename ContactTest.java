import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreatedSuccessfully() {
        Contact contact = new Contact("1234567890", "John", "Smith", "1234567890", "123 Main Street");

        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIDCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testContactIDCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Johnathan99", "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smithington", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", null, "123 Main Street");
        });
    }

    @Test
    public void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "12345", "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotContainLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "12345abcde", "123 Main Street");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "1234567890", null);
        });
    }

    @Test
    public void testAddressCannotBeLongerThanThirty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "1234567890", "1234567890123456789012345678901");
        });
    }
}
