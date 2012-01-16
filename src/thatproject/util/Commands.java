package thatproject.util;

public class Commands {

    private static String[] attacks;
    private static String[] accept = { "yes", "y", "okay", "k" };

    private static String active;

    public static void command(String s) {
        active = s.toLowerCase();

        if (check(attacks)) {
            attack();
        }
        else if (check(accept)) {
            System.out.println("cool!");
        }
    }

    private static boolean check(String[] a) {
        for (String temp : a) {
            if (active.equals(temp))
                return true;
        }
        return false;
    }

    private static void attack() {

    }

}
