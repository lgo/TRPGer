package thatproject.util;

import thatproject.manager.AttackManager;

public class Commands {

    private static String[] attacks = { "boo" };
    private static String[] accept = { "yes", "y", "okay", "k" };
    private static String[] directions = { "n", "s", "e", "w" };

    private static String active;

    public static void command(String s) {
        active = s.toLowerCase();
        if (check(attacks)) {
            attack();
        } else if (check(accept)) {
            Event.accept();
        } else if (active.equals("drop")) {
            Event.drop(true);
        } else if (active.equals("cancel")) {
            Event.drop(false);
        } else if (check(directions)) {
            int dir = s.equals("n") ? 0 : s.equals("s") ? 1 : s.equals("e") ? 2 : 3;
            if (s.equals("n")) {
                dir = 0;
            } else if (s.equals("s")) {
                dir = 1;
            } else if (s.equals("e")) {
                dir = 2;
            } else if (s.equals("w")) {
                dir = 3;
            }

            Event.move(dir);
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
        for (int i = 0; i < attacks.length; i++) {
            if (active.equals(attacks[i])) {
                AttackManager.attack(i);
            }
        }
    }

    /**
     * Inserts string into attack array
     * 
     * @param attack string to insert
     */
    public static void insertAttack(String attack) {
        attacks[attacks.length] = attack;
    }

    /**
     * Setup the attacks array with the appropriate size
     * 
     * @param size for the array
     */
    public static void attackSize(int size) {
        attacks = new String[size];
    }

}
