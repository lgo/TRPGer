package thatproject.entities.being;

import thatproject.actions.Attack;
import thatproject.entities.Monster;
import thatproject.menu.MainMenu;

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
    
    public void hit(int d) {
        hp -= d;
        hp = hp < 0 ? 0 : hp;
        if (hp < 0) {
            MainMenu.add("Congragulations! You have killed the " + name + ".");
        }
        Attack.attackDisplay(this, Attack.SPACES);
    }

}
