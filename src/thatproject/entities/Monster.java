package thatproject.entities;

public class Monster extends Entity {

    public int hpMax;
    public int[] stats;
    public String name;
    public int rate;
    public int[] itemDrops;
    public String encounter;

    public Monster(String name2, int rate2, int health, int[] stats2, int[] itemDrops2, String encounter2) {
        stats = stats2;
        hpMax = health;
        name = name2;
        rate = rate2;
        itemDrops = itemDrops2;
        encounter = encounter2;
    }

    public int getRate() {
        return rate;
    }

}
