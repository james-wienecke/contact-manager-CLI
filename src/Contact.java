public class Contact {
    private Name name;
    private long phone;

    Contact(String name, long phone) {
        this.name = new Name(name);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return getName() + " | " + getPhone();
    }

    public String getName() {
        return name.getFullName();
    }

    public long getPhone() {
        return phone;
    }

    // converts the contact into a String formatted to look like "name,phonenumber"
    public String formatForStorage() {
        return String.format("%s,%s", getName(), getPhone());
    }
}
class Name {
    String first;
    String last;

    public Name(String name) throws ArrayIndexOutOfBoundsException {
        String[] names = name.split(" ");
        this.first = names[0];
        this.last = names[1];
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFullName() {
        return String.format("%s %s", first, last);
    }
}
