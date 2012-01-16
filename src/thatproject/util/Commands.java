package thatproject.util;

import thatproject.manager.AttackManager;

public class Commands {

    private static String[] attacks = { "boo" };
    private static String[] accept = { "yes", "y", "okay", "k" };

    private static String active;

    public static void command(String s) {
        active = s.toLowerCase();

        if (check(attacks)) {
            attack();
        } else if (check(accept)) {
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
