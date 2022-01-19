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
        // return the corresponding Option
        return Option.getOptionFromInt(response);
    }

    public String[] addContactMenu() {
        String newName = in.getString("To enter a new contact, first enter a full name:");
        System.out.println("Now enter a phone number. Examples: 111222333, 001112223333 where 0 is country code, 1 is area code, and 2 and 3 are phone number.");
        String newPhone = in.getString("Note: if no country code is provided it will be assumed to be US (01). Only digits please:");

        return new String[]{newName, newPhone};
    }

    public String searchContactMenu() {
        return in.getString("Enter the name to search for:");
    }
}
