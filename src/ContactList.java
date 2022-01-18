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
}