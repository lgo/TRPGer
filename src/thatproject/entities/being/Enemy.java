package thatproject.entities.being;

import thatproject.entities.Monster;

public class Enemy extends Monster {

    public int hp;
    public int attack;

    public Enemy(Monster m) {
        super(m.name, m.rate, m.hpMax, m.stats, m.itemDrops, m.encounter);
        hp = m.hpMax;
    }

    public int exp() {
        return (int) (hpMax * .5);
    }

}
