package thatproject.manager;

import thatproject.entities.Monster;
import thatproject.entities.being.Enemy;

public class MonsterManager {

    private static Monster[] monsters;
    private static Enemy currentBattle;

    public MonsterManager(int amount) {
        monsters = new Monster[amount];
    }

    public void populateMonsters(int x, int[] stats, String name, String description, String[] encounter, int[] zone) {
        monsters[x] = new Monster(stats, name, encounter);

    }

}
