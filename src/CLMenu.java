public class CLMenu {
    private Input in;

    CLMenu() {
        in = new Input();
    }

    Option mainMenu() {
        // we look through the Options and print their corresponding prompts
        for (Option option : Option.values()) {
            if (option.getNumber() != 0) {
                System.out.printf("(%d) %s%n", option.getNumber(), option.getStringOptionPrompt());
            }
        }
        // take user input in the allowed range of Options
        int response = in.getInt(1, 5, "Enter an option number:");
        // return the corresponding option
        return Option.getOptionFromInt(response);
    }

    public String[] addContactMenu() {
        String newName = in.getString("To enter a new contact, first enter a full name:");
        String newPhone = in.getString("Now enter a phone number. Only digits please:");

        return new String[]{newName, newPhone};
    }
}
