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
}
