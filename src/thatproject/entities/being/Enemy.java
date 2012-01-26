package thatproject.entities.being;

import thatproject.actions.Attack;
import thatproject.entities.Monster;
import thatproject.menu.MainMenu;

public class Enemy extends Monster {

    //declaring variables.
    public int hp;
    public int attack;

    //Takes the values from Monster and puts them into the Enemy object.
    public Enemy(Monster m) {
        super(m.name, m.rate, m.hpMax, m.stats, m.itemDrops, m.encounter);
        hp = m.hpMax;
    }

    //returns an experience value scaled to half of the monster's health.
    public int exp() {
        return (int) (hpMax * .5);
    }

    //function for attacking the enemy.
    public void hit(int d, int attack) {
        hp -= d; //reduces health by the amount of damage dealt
        hp = hp < 0 ? 0 : hp; //check to set monster hp to 0 if deals more than the remaining hp
        //if to check whether or not monster is dead and displays a message if dead.
        if (hp < 0) {
            MainMenu.add("Congragulations! You have killed the " + name + ".");
        }
        Attack.attackDisplay(this, Attack.SPACES); //calls attackDisplay function from the Attack class.
        String temp = "";
        switch (attack) {
            case 0:
                temp += "";
                break;
            case 1:
                temp += "";
                break;
            case 2:
                temp += "";
                break;
        }
    }

}
