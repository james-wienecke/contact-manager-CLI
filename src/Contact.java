public class Contact {
    private Name name;
    private Phone phone;

    Contact(String name, String phone) {
        this.name = new Name(name);
        this.phone = new Phone(phone);
    }

    @Override
    public String toString() {
        return getName() + " | " + getPhoneFormatted(0);
    }

    public String formatString(int phoneNumberFormat, boolean firstBeforeLast) {
        return String.format("%-24s | %-18s |", name.getFullName(firstBeforeLast), getPhoneFormatted(phoneNumberFormat));
    }

    public String getName() {
        return name.getFullName();
    }

    public String getPhone() {
        return phone.getNumber();
    }

    public String getPhoneFormatted(int option) {
        return phone.getNumberFormatted(option);
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

    public String getFullName(boolean firstBeforeLast) {
        if (firstBeforeLast) {
            return String.format("%s %s", first, last);
        } else {
            return String.format("%s %s", last, first);
        }
    }
}

class Phone {
    private String country;
    private String area;
    private String number;

    private static final int E164 = 0;
    private static final int US = 1;
    private static final int INT = 2;
    private static final int UK = 3;

    public Phone(String num) throws IllegalArgumentException {
        if (num.length() == 10) {
            // 111 222 3333
            // 012 345 6789
            country = "001";
            area = num.substring(0, 3);
            number = num.substring(3);
        } else if (num.length() == 11) {
            // 0 111 222 3333
            // 0 123 456 789A
            country = num.substring(0, 1);
            area = num.substring(1, 4);
            number = num.substring(4);
        } else if (num.length() == 12) {
            // 00 111 222 3333
            // 01 234 567 89AB
            country = num.substring(0, 2);
            area = num.substring(2, 5);
            number = num.substring(5);
        } else if (num.length() == 13) {
            // 000 111 222 3333
            // 012 345 678 9ABC
            country = num.substring(0, 3);
            area = num.substring(3, 6);
            number = num.substring(6);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getNumber() {
        return getNumberFormatted(-1);
    }

    public String getNumberFormatted() {
        return getNumberFormatted(0);
    }

    /**
     *
     * @param format 0: E164 format 1: US format 2: ambiguously european format, 3: UK-ish format -1: no format
     * @return
     */
    public String getNumberFormatted(int format) {
        switch (format) {
            case E164:
                return String.format("+%s%s%s", country.substring(1), area, number);
            case US:
                if (country.equalsIgnoreCase("001")) {
                    // (111)222-3333
                    return String.format("(%s)%s-%s", area, number.substring(0, 3), number.substring(3));
                } else {
                    // +00(111)222-3333
                    return String.format("+%s(%s)%s-%s", country.substring(1), area, number.substring(0, 3), number.substring(3));
                }
            case INT:
                // +00 111.222.3333
                return String.format("+%s %s.%s.%s", country.substring(1), area, number.substring(0, 3), number.substring(3));
            case UK:
                // 00 11 1222 3333
                return String.format("%s 0%s %s%s %s", country.substring(1), area.substring(0, 2), area.substring(2), number.substring(0, 3), number.substring(3));
            default:
                // 0001112223333
                return String.format("%s%s%s", country, area, number);
        }
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
