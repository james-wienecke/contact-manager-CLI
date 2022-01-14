public class CLMenu {
    private Input in;

    CLMenu() {
        in = new Input();
    }

    Option printMenu() {
        String mainMenu = "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):";

        int userResponse = in.getInt(1, 5, mainMenu);
        Option option = Option.UNKNOWN;

        switch (userResponse) {
            case 1:
                option = Option.VIEW;
                break;
            case 2:
                option = Option.ADD;
                break;
            case 3:
                option =  Option.SEARCH;
                break;
            case 4:
                option = Option.DELETE;
                break;
            case 5:
                option = Option.EXIT;
                break;
        }

        return option;
    }
}
