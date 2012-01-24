package thatproject.actions;

import java.util.Random;

import thatproject.entities.being.Enemy;

public class Attack {

    private static final String n = "\n"; //Short form for "\n"
    private static Random generator = new Random(); //creates generator for use other than double

    public static final int SPACES = 20; //spaces required for monster health bar.

    //Displays current health of monster and health bar by calling healthDisplay.
    public static String attackDisplay(int hp, int hpMax, int spaces, String name) {
        hp = hp < 0 ? 0 : hp; //if health less than zero, sets to 0
        return name + n + "Health: " + healthDisplay(hp, hpMax, spaces); //returns the monster's health
    }

    //calls first attackDisplay function
    public static String attackDisplay(Enemy e, int spaces) {
        return attackDisplay(e.hp, e.hpMax, spaces, e.name); //returns values of the variables.
    }

    //Displays the health bar of the monster
    public static String healthDisplay(int hp, int hpMax, int spaces) {
        float h = hp, hm = hpMax, s = spaces; //converts the input variables to doubles.
        String r = "["; //initializes String r
        for (int i = 0; i < spaces; i++) { //for loop for checking hp and adding to health bar.
            if (i == 0 && hp > 0) {
                r += "=";
            } else if (i + 1 <= h / hm * s) {
                r += "=";
            } else {
                r += " ";
            }
        }
        r += "] " + Integer.toString(hp) + "/" + Integer.toString(hpMax); //finishes adding to String r
        return r; //returns r
    }

    //attack function
    public static int attack(int low, int high) {
        return generator.nextInt(high - low) + low; //generates attack damage
    }

    public static void attack(int i) {
    }
}
