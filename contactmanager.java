import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added!");
    }

    public boolean removeContact(int index) {
        if(index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            return true;
        }
        return false;
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public int getSize() {
        return contacts.size();
    }
}
