import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ContactList {
    private ArrayList<Contact> list;
    private Path dataDir;
    private Path dataFile;

    ContactList() {
        this.list = new ArrayList<>();

        // load contacts from file
        readContactsFromFile();
    }

    public void readContactsFromFile() {
        // Contact data is to be read and saved to relative path "../data/contacts.txt"
        dataDir = Paths.get("data");
        dataFile = Paths.get("data", "contacts.txt");
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

    // runs through all Contacts in the contactList and prints them to console
    public void printAllContacts() {
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }

    // takes a length 2 array of String name and String long to build a new Contact from
    // then adds it to the end of the ContactList list
    public void addNewContact(String[] contactData) throws NumberFormatException {
        list.add(new Contact(contactData[0], Long.parseLong(contactData[1])));
    }

    // searches through the ContactList and attempts to print a Contact's details
    // matching the provided name String passed into itself
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

    // searches through the ContactList and returns a Contact with a name String
    // that matches the String passed into itself
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

    // attempts to find a contact by matching the String it is provided to a Contact's name
    // if one is found, it is removed from the list and destroyed
    public void deleteContact(String nameQuery) {
        Contact result = searchContacts(nameQuery);
        list.remove(result);
        System.out.println("Contact removed.");
    }

    // adds the list of strings it contains as Contacts into the ContactList
    public void addContacts(List<String> fileData) {
        fileData.forEach(line -> {
            String[] contactData = line.split(",");
            list.add(new Contact(contactData[0], Long.parseLong(contactData[1])));
        });
    }

    // takes the current ContactList, then copies its elements as formatted Strings
    // into a new list. Then it overwrites the data/contacts.txt with the new list
    public void saveContactsToFile() {
        ArrayList<String> formattedList = new ArrayList<>();

        list.forEach(contact -> formattedList.add(contact.formatForStorage()));

        try {
            Files.write(dataFile, formattedList);
        } catch (IOException iox) {
            System.out.println("Failed to write contact list to storage.");
        }
    }
}
