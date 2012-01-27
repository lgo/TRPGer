package thatproject.util;

import java.util.Random;

public class Formulas {

    private static final Random generator = new Random();

    /**
     * Returns whether missed or hit
     * 
     * @param percent chance of hit
     * @return hit t or f
     */
    public static boolean hit(int percent) {
        return generator.nextInt(100) <= percent ? true : false;
    }

    /**
     * Attack calculator
     * 
     * @param str
     * @return attack amount
     */
    public static int attack(int str) {
        return 2 + str * 3;
    }

    //UNUSED
    public static int defence(int lvl, int end, int str) {
        return lvl * 2 + end * 3 + str;
    }

    //UNUSED
    public static int critical(int luc) {
        return 4 + luc;
    }

    //UNUSED
    public static int avoid(int dex, int lvl) {
        return lvl * 2 + dex * 3;
    }

}
