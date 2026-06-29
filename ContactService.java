import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            return false;
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    public boolean updateFirstName(String contactID, String firstName) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setFirstName(firstName);
            return true;
        }
        return false;
    }

    public boolean updateLastName(String contactID, String lastName) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setLastName(lastName);
            return true;
        }
        return false;
    }

    public boolean updatePhone(String contactID, String phone) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setPhone(phone);
            return true;
        }
        return false;
    }

    public boolean updateAddress(String contactID, String address) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setAddress(address);
            return true;
        }
        return false;
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
