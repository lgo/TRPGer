package thatproject.entities;

public class Monster extends Entity {

    public int hpMax;
    public int[] stats;
    public String name;
    public int rate;

    public Monster(int s[], int hp, String n, int r) {
        stats = s;
        hpMax = hp;
        name = n;
        rate = r;

    }

    public int getRate() {
        return rate;
    }

}
