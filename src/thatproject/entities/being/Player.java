package thatproject.entities.being;

import thatproject.ThatProject;
import thatproject.entities.Entity;

public class Player extends Entity {

    public int hp, hpMax;
    private int lvl, exp, str, end, dex, luc, gold;
    private int x, y;

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
        ThatProject.threadFreeze = false;
    }

}
