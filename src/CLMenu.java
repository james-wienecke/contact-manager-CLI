public class CLMenu {
    private final Input in;

    CLMenu() {
        this(new Input());
    }

    CLMenu(Input in) {
        this.in = in;
    }

    Option mainMenu() {
        // we look through the Options and print their corresponding prompts
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.printf("│ %-46s│%n", "Main Menu");
        for (Option option : Option.values()) {
            if (option.getNumber() != 0) {
                System.out.printf("│ (%d) %-42s│%n", option.getNumber(), option.getStringOptionPrompt());
            }
        }
        System.out.println("└───────────────────────────────────────────────┘");

        // take user input in the allowed range of Options
        int response = in.getInt(1, 6, "Enter an option number:");
        // return the corresponding Option
        return Option.getOptionFromInt(response);
    }

    public String[] addContactMenu() {
        String newName = in.getString("To enter a new contact, first enter a full name:");
        System.out.println("Now enter a phone number. Examples: 111222333, 0001112223333 where 0 is country code, 1 is area code, and 2 and 3 are phone number.");
        String newPhone = in.getString("Note: if no country code is provided it will be assumed to be US (01). Only digits please:");

        return new String[]{newName, newPhone};
    }

    public String searchContactMenu() {
        return in.getString("Enter your search terms:");
    }

    public boolean configFirstBeforeLastName() {
        if (in.yesNo("Do you want to swap whether names are formatted firstname lastname or lastname firstname?")) {
            System.out.println("Swapping order...");
            return true;
        } else {
            return false;
        }
    }

    public int configPhoneNumberFormat() {
        String formatPrompt = "What format would you like to change phone number display to? Default is E.164.\n" +
                "0: E.164\n" +
                "1: US style\n" +
                "2: Common international style\n" +
                "3: UK style";
        return in.getInt(0, 3, formatPrompt);
    }
}
