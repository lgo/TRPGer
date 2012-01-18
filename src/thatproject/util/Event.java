package thatproject.util;

public class Event {

    private static boolean drop = false;

    public static void accept() {

    }

    public static void drop(boolean dropmode) {
        if (dropmode) {
            if (drop) {

            } else if (!drop) {

            }
        } else if (!dropmode) {
            if (drop) {

            } else if (!drop) {

            }
        }
    }
}
