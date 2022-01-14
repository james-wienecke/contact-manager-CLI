public class App {

    public static void main(String[] args) {
        CLMenu menu = new CLMenu();
        Option option = Option.UNKNOWN;
        boolean cont = true;

        do {
            option = menu.printMenu();

            switch (option) {
                case VIEW:
                    // view contacts
                    System.out.println("View contact");
                    break;
                case ADD:
                    // add a contact
                    System.out.println("Add contact");
                    break;
                case SEARCH:
                    // search contacts
                    System.out.println("Search contact");
                    break;
                case DELETE:
                    // delete a contact
                    System.out.println("Delete contact");
                    break;
                case EXIT:
                    // exit program
                    System.out.println("Exiting...");
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
