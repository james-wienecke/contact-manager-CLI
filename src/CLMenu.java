public class CLMenu {
    private Input in;

    CLMenu() {
        in = new Input();
    }

    void printMenu() {
        String mainMenu = "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):";

        String userResponse = in.getString(mainMenu);




    }
}
