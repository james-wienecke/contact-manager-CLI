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

        int response = in.getInt(1, 5, mainMenu);
        return Option.getOptionFromInt(response);
    }

    public String[] addContactMenu() {
        String newName = in.getString("To enter a new contact, first enter a full name:");
        String newPhone = in.getString("Now enter a phone number. Only digits please:");

        return new String[]{newName, newPhone};
    }
}
