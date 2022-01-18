public class App {

    public static void main(String[] args) {
        // we initialize the contact list here so it sets itself up before
        // we hand control over to user input
        ContactList list = new ContactList();

        // we open up the command line main menu
        runCommandLine(list);
    }

    /** Initializes a command line interface and waits to manipulate the ContactList according
     * to Option enum values returned from it.
     *
     * @param list
     */
    public static void runCommandLine(ContactList list) {
        CLMenu menu = new CLMenu();
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
                        System.out.println("You Successfully added a contact");
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
//                    list.saveContactsToFile();
                    break;
            }
        } while (option != Option.EXIT);
    }
}
