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
                        System.out.println("You successfully added a contact.");
                    } catch (NumberFormatException numErr) {
                        System.out.println("Invalid phone number. Try again.");
                    }
                    break;
                case SEARCH:
                    // search contacts
                    System.out.println("Search contact");
                    list.searchAndPrintContact(menu.searchContactMenu());
                    break;
                case DELETE:
                    // delete a contact
                    System.out.println("Delete contact");
                    list.deleteContact(menu.searchContactMenu());
                    break;
                case EXIT:
                    // exit program
                    System.out.println("Exiting...");
                    list.saveContactsToFile();
                    break;
            }
        } while (option != Option.EXIT);
    }
}
