package thatproject.entities.being;

import thatproject.Game;
import thatproject.entities.Entity;
import thatproject.menu.MainMenu;
import thatproject.util.Formulas;

public class Player extends Entity {

    //declaring and initializing variables
    public int hp, hpMax, stamina = 100, staminaMax = stamina;
    private int lvl, exp;
    public int str;
    private int end;
    private int dex;
    private int luc;
    private int gold;
    private int x, y;
    public int spareStats = 4;

    //initializing renaining stats.
    public Player(int[] stats) {
        lvl = stats[0];
        exp = stats[1];
        str = stats[2];
        end = stats[3];
        dex = stats[4];
        luc = stats[5];
        gold = stats[6];
        hp = stats[7];
        hpMax = stats[8];
        x = stats[9];
        y = stats[10];
    }

    //calculates damage to deal to enemy
    public int[] calculateDamage() {
        int temp = Formulas.attack(str);
        int[] temp2 = { (int) (temp * 0.7), temp };
        return temp2;
    }

    //checks to see if exp required to level up has been reached
    public void checkXP() {
        double temp;
        //reduces exp and levels up player when required exp reached.
        if (exp == (temp = 100 * Math.pow(1.15, lvl))) {
            exp -= temp;
            levelUp();
        }
    }

    //increases player level, gives stats points, and assigns/refreshes player's health value.
    public void levelUp() {
        lvl++;
        spareStats += 5;
        hpMax = 86 + str + end * 5 + lvl * 8;
        MainMenu.refreshHP();
    }

    /**
     * Add stats on with spare stat points
     * 
     * @param stat (0 = str)(1 = dex)(2 = end)(3 = luc)
     */
    public void statUp(int stat) {
        switch (stat) {
            case 0:
                str++;
                break;
            case 1:
                dex++;
                break;
            case 2:
                end++;
                break;
            case 3:
                luc++;
                break;
        }
        spareStats--; //lowers spare stat point used to increase a stat
        hpMax = 86 + str + end * 5 + lvl * 8; //assigns new max health value
        MainMenu.refreshHP(); //displays new max health value
    }

    //Function for using a healing item
    public void heal(int stat) {
        hp = hp + stat > hpMax ? hpMax : hp + stat; //Adds value to health and just sets to max health if increases by more than max
        MainMenu.refreshHP(); //displays new health value
    }

    //Function for taking damage from enemy
    public void hit(int damage) {
        hp -= damage; //reduces health
        MainMenu.refreshHP(); //displays new health
        //checks to see if you die, and if true calls gameover()
        if (hp <= 0) {
            Game.gameover();
        }
    }

}
