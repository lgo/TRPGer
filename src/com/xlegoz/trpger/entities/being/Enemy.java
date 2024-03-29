package com.xlegoz.trpger.entities.being;

import com.xlegoz.trpger.Game;
import com.xlegoz.trpger.actions.Attack;
import com.xlegoz.trpger.entities.Monster;
import com.xlegoz.trpger.gui.StandardMenu;

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

        StandardMenu.set(Attack.attackDisplay(this, Attack.SPACES));//calls attackDisplay function from the Attack class.
        if (hp == 0) {//if to check whether or not monster is dead and displays a message if dead.

            StandardMenu.add("\n\nCongragulations! You have killed the " + name + ".");
            StandardMenu.addTemp("\nType 'continue' to move on.");
            Game.e = null;
            return;
        }
        String temp = "";
        switch (attack) {
            case 0:
                temp += "\nYou swing at the " + name + " slash for " + d + ".";
                break;
            case 1:
                temp += "\nYou go to impale the " + name + " for " + d + ".";
                break;
            case 2:
                temp += "\nYou whale towards the " + name + " hit it bluntly for " + d + ".";
                break;
            case 3:
                temp += "\nYou swung at the " + name + " and missed.";
                break;
        }
        temp += enemyAttack();
        if (!Game.done) {
            StandardMenu.add(temp);
        }
    }

    /**
* Calculate enemy attack and produce a string for the attack, damage player
*
* @return string of attack line
*/
    private String enemyAttack() {
        int temp = Attack.attack((int) (stats[0] * 0.8), (int) (stats[0] * 1.2));
        Game.p.hit(temp);
        return "\n" + name + " attacked you for " + temp + ".";
    }

}