import java.util.Scanner;

public class Input {
    private final Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    public String getString() {
        String input = sc.nextLine();
        if (input.isEmpty())
            return getString();
        else
            return input;
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        String input = sc.nextLine();
        if (input.isEmpty())
            return getString(prompt);
        else
            return input;
    }

    public boolean yesNo() {
        String in = getString().trim();
        if (in.equalsIgnoreCase("yes") ||
                in.equalsIgnoreCase("y") ||
                in.equalsIgnoreCase("si") ||
                in.equalsIgnoreCase("1") ||
                in.equalsIgnoreCase("affirmative") ||
                in.equalsIgnoreCase("ok") ||
                in.equalsIgnoreCase("yup") ||
                in.equalsIgnoreCase("sure") ||
                in.equalsIgnoreCase("of course")) {
            return true;
        } else return false;
    }

    public boolean yesNo(String prompt) {
        String in = getString(prompt).trim();
        if (in.equalsIgnoreCase("yes") ||
                in.equalsIgnoreCase("y") ||
                in.equalsIgnoreCase("si") ||
                in.equalsIgnoreCase("1") ||
                in.equalsIgnoreCase("affirmative") ||
                in.equalsIgnoreCase("ok") ||
                in.equalsIgnoreCase("yup") ||
                in.equalsIgnoreCase("sure") ||
                in.equalsIgnoreCase("of course")) {
            return true;
        } else return false;
    }

    public int getInt() {
        int input;
        try {
            input = Integer.valueOf(getString());
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getInt();
        }
        return input;
    }

    public int getInt(String prompt) {
        int input;
        try {
            input = Integer.valueOf(getString(prompt));
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getInt(prompt);
        }
        return input;
    }

    public int getInt(int min, int max) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getInt(max, min);
        int userInt = getInt();
        if (userInt < min || userInt > max)
            return getInt(min, max);
        else
            return  userInt;
    }

    public int getInt(int min, int max, String prompt) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getInt(max, min);
        int userInt = getInt(prompt);
        if (userInt < min || userInt > max)
            return getInt(min, max, prompt);
        else
            return  userInt;
    }

    public double getDouble() {
        double input;
        try {
            input = Double.valueOf(getString());
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getDouble();
        }
        return input;
    }

    public double getDouble(String prompt) {
        double input;
        try {
            input = Double.valueOf(getString(prompt));
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getDouble(prompt);
        }
        return input;
    }


    public double getDouble(double min, double max) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getDouble(max, min);
        double input = getDouble();
        if (input < min || input > max)
            return getDouble(min, max);
        else
            return  input;
    }

    public double getDouble(double min, double max, String prompt) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getDouble(max, min, prompt);
        double input = getDouble(prompt);
        if (input < min || input > max)
            return getDouble(min, max, prompt);
        else
            return  input;
    }

    public void waitForAnyLine() {
        String input = sc.nextLine();
    }

    public void waitForAnyLine(String prompt) {
        System.out.println(prompt);
        String input = sc.nextLine();
    }

    public int getBinary() {
        int input;
        try {
            input = Integer.valueOf(getString(), 2);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getBinary();
        }
        return input;
    }

    public int getBinary(String prompt) {
        int input;
        try {
            input = Integer.valueOf(getString(prompt), 2);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getBinary(prompt);
        }
        return input;
    }

    public int getBinary(int min, int max) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getBinary(max, min);
        int userInt = getBinary();
        if (userInt < min || userInt > max)
            return getBinary(min, max);
        else
            return  userInt;
    }

    public int getBinary(int min, int max, String prompt) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getBinary(max, min);
        int userInt = getBinary(prompt);
        if (userInt < min || userInt > max)
            return getBinary(min, max, prompt);
        else
            return  userInt;
    }

    public int getHex() {
        int input;
        try {
            input = Integer.valueOf(getString(), 16);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getHex();
        }
        return input;
    }

    public int getHex(String prompt) {
        int input;
        try {
            input = Integer.valueOf(getString(prompt), 16);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            input = getInt(prompt);
        }
        return input;
    }

    public int getHex(int min, int max) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getHex(max, min);
        int userInt = getHex();
        if (userInt < min || userInt > max)
            return getHex(min, max);
        else
            return  userInt;
    }

    public int getHex(int min, int max, String prompt) {
        // if min is smaller than max we can fix automatically
        if (min > max)
            return getHex(max, min);
        int userInt = getHex(prompt);
        if (userInt < min || userInt > max)
            return getHex(min, max, prompt);
        else
            return  userInt;
    }
}
