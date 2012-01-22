package thatproject.entities;

public class Monster extends Entity {

    public int hpMax;
    public int[] stats;
    public String name;

    public Monster(int s[], int hp, String n) {
        stats = s;
        hpMax = hp;
        name = n;
    }

}
