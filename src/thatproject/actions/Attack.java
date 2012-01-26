package thatproject.actions;

import java.util.Random;

import thatproject.Game;
import thatproject.entities.being.Enemy;
import thatproject.world.World;

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

    /**
     * Call and execute attack procedure
     * 
     * @param i (0 = slash)(1 = stab)(2 = crush)
     */
    public static void attack(int i) {
        int attackLow = 0, attackHigh = 0, accuracy = 0;
        int[] temp = Game.p.calculateDamage();
        switch (i) {
            case 0:
                attackLow = (int) (temp[0] * 0.7);
                attackHigh = (int) (temp[1] * 0.7);
                accuracy = 100;
                break;
            case 1:
                attackLow = temp[0];
                attackHigh = temp[1];
                accuracy = 80;
                break;
            case 2:
                attackLow = (int) (temp[0] * 1.2);
                attackHigh = (int) (temp[1] * 1.2);
                accuracy = 65;
                break;
        }
        if (generator.nextInt(100) > accuracy) {
            Game.e.hit(0, 3);
        } else {
            Game.e.hit(attack(attackLow, attackHigh), i);

        }
    }

    public static void endCombat() {
        World.nextMap.postCombat(World.nextMapInt);
    }
}
