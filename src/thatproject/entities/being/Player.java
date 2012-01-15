package thatproject.entities.being;

import thatproject.entities.Entity;

public class Player extends Entity {

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
        x = stats[7];
        y = stats[8];
    }

}
