import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;
    private static final String FILE_NAME = "contacts.json";

    public ContactManager() {
        contacts = loadContacts();
    }

    private List<Contact> loadContacts() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Gson gson = new Gson();
            Type contactListType = new TypeToken<ArrayList<Contact>>(){}.getType();
            List<Contact> list = gson.fromJson(reader, contactListType);
            return list != null ? list : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveContacts() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new Gson();
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }

    public void addContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
        saveContacts();
    }

    public boolean removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            saveContacts();
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
