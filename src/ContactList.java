import java.util.ArrayList;


public class ContactList {
    private ArrayList<Contact> list;
    ContactList() {
        this.list = new ArrayList<>();
        buildTestList(3);
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

    public void searchContacts(String nameQuery) {
        boolean found = false;
        for (Contact contact : list) {
            if (contact.getName().equalsIgnoreCase(nameQuery)) {
                found = true;
                System.out.println(contact);
            }
        }
        if (!found) {
            System.out.println("No contacts match your search term.");
        }
    }
}
