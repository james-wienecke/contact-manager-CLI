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
        Input in = new Input();
        CLMenu menu = new CLMenu(in);
        Option option;
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
                        boolean wouldCollide = list.addNewContact(menu.addContactMenu());
                        if (wouldCollide) {
                            System.out.println("Contact name or phone number already exists, stopping addition.");
                        } else {
                            System.out.println("You successfully added a contact.");
                        }
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
                case CONFIG:
                    System.out.println("Edit preferences");
                    list.setFirstBeforeLast(menu.configFirstBeforeLastName());
                    list.setPhoneNumberFormat(menu.configPhoneNumberFormat());
                    System.out.println("Preferences changed.");
                    break;
                case EXIT:
                    // exit program
                    System.out.println("Exiting...");
                    list.saveContactsToFile();
                    break;
            }
            if (option != Option.EXIT) in.waitForAnyLine("Press enter or return to go back to menu...");
        } while (option != Option.EXIT);
    }
}
