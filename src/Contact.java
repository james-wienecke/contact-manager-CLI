public class Contact {
    private String name;
    private long phone;

    Contact(String name, long phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " | " + phone;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    // converts the contact into a String formatted to look like "name,phonenumber"
    public String formatForStorage() {
        return String.format("%s,%s", name, phone);
    }
}
