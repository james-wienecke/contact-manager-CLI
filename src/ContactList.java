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

   public void searchAndPrintContact(String query) {
      try {
         Contact contact = searchContactByName(query);
         System.out.println(contact);
      } catch (NullPointerException npe) {
         System.out.println("There is no contact in this list with the name " + query);
      }
   }

   public Contact searchContactByName(String nameSearch) {
      Contact found = null;
      for (Contact contact : list) {
         if (contact.getName().equalsIgnoreCase(nameSearch)) {
            found = contact;
         }
      }
      return found;
   }

   public void deleteContact(String query) {
      try {
         Contact contact = searchContactByName(query);
         list.remove(contact);
      } catch (NullPointerException npe) {
         System.out.println("There is no contact by the name of " + query);
      }
   }
}