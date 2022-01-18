import java.util.ArrayList;

public class ContactList {
   ArrayList<Contact> list;

   public ContactList() {
      this.list = new ArrayList<>();
   }

   public void printAllContacts() {
      for(Contact contact:list){
         System.out.println(contact.toString());
      }
   }

   public void addNewContact(String[] newContact) {
      Contact contact = new Contact(newContact[0], Long.parseLong(newContact[1]));
      list.add(contact);
   }

    public void searchAndPrintContact(String searchContactMenu) {
    }
}