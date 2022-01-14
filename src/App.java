import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        CLMenu menu = new CLMenu();
        ContactList list = new ContactList();

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
            List<Contact> contactsList = new ArrayList<Contact>();
            contactsList.add(new Contact("james w", 2122445));

//            System.out.println(contactsList.get(0));


            List<String> fileData = Files.readAllLines(dataFile);
            System.out.println(fileData);
        } catch(IOException iox) {
            iox.printStackTrace();
        }




//        runCommandLine(menu, list);
    }

    public static void runCommandLine(CLMenu menu, ContactList list) {
        Option option = Option.UNKNOWN;
        do {
            option = menu.mainMenu();
            switch (option) {
                case VIEW:
                    // view contacts
                    System.out.println("View contact");
                    list.printAllContacts();
                    break;
                case ADD:
                    // add a contact
                    System.out.println("Add contact");
                    try {
                        list.addNewContact(menu.addContactMenu());
                    } catch (NumberFormatException numErr) {
                        System.out.println("Invalid phone number. Try again.");
                    }
                    break;
                case SEARCH:
                    // search contacts
                    System.out.println("Search contact");
                    try {
                        list.searchAndPrintContact(menu.searchContactMenu());
                    } catch (NullPointerException notFound) {
                        System.out.println("No contacts match your search term.");
                    }
                    break;
                case DELETE:
                    // delete a contact
                    System.out.println("Delete contact");
                    try {
                        list.deleteContact(menu.searchContactMenu());
                    } catch (NullPointerException notFound) {
                        System.out.println("No contacts match your search time.");
                    }
                    break;
                case EXIT:
                    // exit program
                    System.out.println("Exiting...");
                    break;
            }
        } while (option != Option.EXIT);
    }
}
