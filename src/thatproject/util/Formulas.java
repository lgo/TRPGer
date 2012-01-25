package thatproject.util;

import java.util.Random;

public class Formulas {

    private static final Random generator = new Random();

    public static boolean hit(int percent) {
        return generator.nextInt(100) <= percent ? true : false;
    }

    public static int attack(int str) {
        return 2 + str * 3;
    }

    public static int defence(int lvl, int end, int str) {
        return lvl * 2 + end * 3 + str;
    }

    public static int critical(int luc) {
        return 4 + luc;
    }

    public static int avoid(int dex, int lvl) {
        return lvl * 2 + dex * 3;
    }

}
