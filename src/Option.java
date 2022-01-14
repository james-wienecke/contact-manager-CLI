public enum Option {
    VIEW (1, "View contacts."),
    ADD (2, "Add a new contact."),
    SEARCH (3, "Search a contact by name."),
    DELETE (4, "Delete an existing contact."),
    EXIT (5, "Exit."),
    UNKNOWN (0, "Invalid option.");

    private final int number;
    private final String stringOption;

    Option(int number, String option) {
        this.number = number;
        this.stringOption = option;
    }



    public static Option getOptionFromInt(int input) {
        switch (input) {
            case 1:
                return Option.VIEW;
            case 2:
                return Option.ADD;
            case 3:
                return Option.SEARCH;
            case 4:
                return Option.DELETE;
            case 5:
                return Option.EXIT;
            default:
                return Option.UNKNOWN;
        }
    }

    public String getStringOptionPrompt() {
        return this.stringOption;
    }

    public int getNumber() {
        return number;
    }
}
