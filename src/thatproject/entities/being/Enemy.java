package thatproject.entities.being;

import thatproject.entities.Monster;

public class Enemy extends Monster {

    public int hp;
    public int attack;

    public Enemy(Monster m) {
        super(m.stats, m.hpMax, m.name);
        hp = m.hpMax;
    }

}
