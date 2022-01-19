public class Contact {
    private Name name;
    private Phone phone;

    Contact(String name, String phone) {
        this.name = new Name(name);
        this.phone = new Phone(phone);
    }

    @Override
    public String toString() {
        return getName() + " | " + getPhone();
    }

    public String getName() {
        return name.getFullName();
    }

    public String getPhone() {
        return phone.getNumber();
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

class Phone {
    private String country;
    private String area;
    private String number;

    private static final int E164 = 0;
    private static final int US = 1;
    private static final int INT = 2;

    public Phone(String num) throws Exception {
        if (num.length() == 10) {
            country = "1";
            area = num.substring(0, 2);
            number = num.substring(3);
        } else if (num.length() >= 11){
            country = num.substring(0, 2);
            area = num.substring(3, 5);
            number = num.substring(6);
        } else {
            throw new E();
        }
    }

    public String getNumber() {
        return getNumberFormatted();
    }

    public String getNumberFormatted() {
        return getNumberFormatted(0);
    }

    public String getNumberFormatted(int format) {
        switch (format) {
            case E164:
                return String.format("+%s%s%s", country, area, number);
            case US:
                if (country.equalsIgnoreCase("1")) {
                    return String.format("(%s) %s-%s", area, number.substring(0, 2), number.substring(3));
                } else {
                    return String.format("%s (%s) %s-%s", country, area, number.substring(0, 2), number.substring(3));
                }
            case INT:
                return String.format("%s-%s-%s-%s", country, area, number.substring(0, 2), number.substring(3));
            default:
                return String.format("%s%s%s", country, area, number);
        }
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
