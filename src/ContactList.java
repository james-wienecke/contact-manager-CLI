import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ContactList {
    private ArrayList<Contact> list;
    ContactList() {
        this.list = new ArrayList<>();
        readContactsFromFile();
    }

    public void readContactsFromFile() {
        Path dataDir = Paths.get("data");
        Path dataFile = Paths.get("data", "contacts.txt");

        try {
            if (Files.notExists(dataDir)) {
                Files.createDirectories(dataDir);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }
        } catch(IOException iox) {
            iox.printStackTrace();
        }

        try {
            List<String> fileData = Files.readAllLines(dataFile);

            addContacts(fileData);

        } catch(IOException iox) {
            iox.printStackTrace();
        }
    }

    public void buildTestList(int numberOfContacts) {
        for (int i = 0; i < numberOfContacts; i++) {
            list.add(new Contact("daniel danielson", 7777777777L));
        }
    }

    public void printAllContacts() {
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }

    public void addNewContact(String[] contactData) throws NumberFormatException {
        list.add(new Contact(contactData[0], Long.parseLong(contactData[1])));
    }

    public void searchAndPrintContact(String nameQuery) {
        boolean found = false;
        for (Contact contact : list) {
            if (contact.getName().equalsIgnoreCase(nameQuery)) {
                found = true;
                System.out.println(contact);
            }
        }
        if (!found) {
            throw new NullPointerException();
        }
    }

    private Contact searchContacts(String nameQuery) {
        Contact result = null;
        boolean found = false;
        for (Contact contact : list) {
            if (contact.getName().equalsIgnoreCase(nameQuery)) {
                found = true;
                result = contact;
            }
        }
        return result;
    }

    public void deleteContact(String nameQuery) {
        Contact result = searchContacts(nameQuery);
        list.remove(result);
        System.out.println("Contact removed.");
    }

    public void addContacts(List<String> fileData) {
//        ArrayList<Contact> added = new ArrayList<>();
        fileData.forEach(line -> {
            String[] contactData = line.split(",");
            list.add(new Contact(contactData[0], Long.parseLong(contactData[1])));
        });
    }
}
