package thatproject.actions;

import java.util.Random;

import thatproject.entities.being.Enemy;
import thatproject.entities.being.Player;

public class Attack {

    private static final String n = "\n";
    private static Random generator = new Random();

    public static final int SPACES = 20;

    public static String attackDisplay(int hp, int hpMax, int spaces, String name) {
        return name + n + "Health: " + healthDisplay(hp, hpMax, spaces);
    }

    public static String attackDisplay(Enemy e, int spaces) {
        return attackDisplay(e.hp, e.hpMax, spaces, e.name);
    }

    public static String healthDisplay(int hp, int hpMax, int spaces) {
        double h = hp, hm = hpMax, s = spaces;
        String r = "[";
        for (int i = 0; i < spaces; i++) {
            if (i == 0 && hp > 0) {
                r += "=";
            } else if (i + 1 <= h / hm * s) {
                r += "=";
            } else {
                r += " ";
            }
        }
        r += "] " + Integer.toString(hp) + "/" + Integer.toString(hpMax);
        return r;
    }

    public static int attack(Player p) {
        return 0;

    }

    public static int attack(int low, int high) {
        return generator.nextInt(high - low) + low;
    }
}
