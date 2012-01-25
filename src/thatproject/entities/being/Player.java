package thatproject.entities.being;

import thatproject.entities.Entity;

public class Player extends Entity {

    public int hp, hpMax, stamina = 100, staminaMax = stamina;
    private int lvl, exp, str, end, dex, luc, gold;
    private int x, y;
    public int spareStats = 4;

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

    public void checkXP() {
        if (exp == 100 * Math.pow(1.15, lvl)) {
            exp -= 100 * Math.pow(1.15, lvl);
            levelUp();
        }
    }

    public void levelUp() {
        lvl++;
        spareStats += 5;
        hpMax = 86 + str + end * 5 + lvl * 8;
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
        spareStats--;
        hpMax = 86 + str + end * 5 + lvl * 8;
    }

}
