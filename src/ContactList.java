import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ContactList {
   ArrayList<Contact> list;
   Path dataDir;
   Path dataFile;

   // user preferences
   int phoneNumberFormat;
   boolean firstBeforeLast;

   public ContactList() {
      this.list = new ArrayList<>();
      this.phoneNumberFormat = 0;
      this.firstBeforeLast = true;

      loadContactsFromFile();
   }

   private void loadContactsFromFile() {
      try {
         dataDir = Paths.get("data");
         dataFile = Paths.get("data", "contacts.txt");

         if (Files.notExists(dataDir)) {
            Files.createDirectories(dataDir);
         }

         if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
         }

         List<String> fileList = Files.readAllLines(dataFile);
         for (String line : fileList) {
            addNewContact(line.split(","));
         }
      } catch (IOException iox) {
         iox.printStackTrace();
      }
   }

   public void saveContactsToFile() {
      List<String> writeBuffer = new ArrayList<>();
      for (Contact contact : list) {
         writeBuffer.add(contact.formatForStorage());
      }
      try {
         Files.write(dataFile, writeBuffer);
      } catch (IOException iox) {
         iox.printStackTrace();
      }
   }

   public void printAllContacts() {
      printContactHeader();
      for(Contact contact:list){
         printContact(contact);
      }
      printContactFooter();
   }

   private void printContact(Contact contact) {
      System.out.println(contact.formatString(phoneNumberFormat, firstBeforeLast));
   }

   private void printContactHeader() {
      System.out.println("┌──────────────────────────┬────────────────────┐");
      System.out.printf("│ %-24s │ %-18s │%n", "Name", "Phone");
      System.out.println("├──────────────────────────┼────────────────────┤");
   }

   private void printContactFooter() {
      System.out.println("└──────────────────────────┴────────────────────┘");
   }

   public boolean addNewContact(String[] newContact) {
      boolean wouldCollide = false;
      for (Contact contact : list) {
         Contact nameMatch = searchContactAllFields(newContact[0], contact);
         Contact phoneMatch = searchContactAllFields(newContact[1], contact);
         if (nameMatch != null || phoneMatch != null) {
            wouldCollide = true;
            break;
         }
      }
      if (!wouldCollide) {
         Contact contact = new Contact(newContact[0], newContact[1]);
         list.add(contact);
      }
      return wouldCollide;
   }

   public void searchAndPrintContact(String query) {
      printContactHeader();
      boolean anyMatch = false;
      for (Contact contact : list) {
         Contact match = searchContactAllFields(query, contact);
         if (match != null) {
            printContact(match);
            anyMatch = true;
         }
      }
      printContactFooter();
      if (!anyMatch) System.out.println("There is no contact in this list matching the term \"" + query + "\"");
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

   public Contact searchContactAllFields(String query, Contact contact) {
      Contact found = null;
      if (contact.getName().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)) ||
         contact.getPhone().contains(query)) {
         found = contact;
      }
      return found;
   }

   public void deleteContact(String query) {
      try {
         Contact contact = searchContactByName(query);
         list.remove(contact);
         System.out.println(query + "removed");
      } catch (NullPointerException npe) {
         System.out.println("There is no contact by the name of " + query);
      }
   }

   public void setPhoneNumberFormat(int preference) {
      phoneNumberFormat = preference;
   }

   public void setFirstBeforeLast(boolean preference) {
      firstBeforeLast = (preference != firstBeforeLast);
   }
}