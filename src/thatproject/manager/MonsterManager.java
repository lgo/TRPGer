package thatproject.manager;

import java.util.ArrayList;

import thatproject.entities.Monster;
import thatproject.entities.being.Enemy;

public class MonsterManager {

    private static ArrayList<Monster> monsters = new ArrayList<Monster>();
    private static Enemy currentBattle;

    public static void populateMonsters(int[] stats, String name, String description, String[] encounter, int[] zone) {
        monsters.add(new Monster(stats, name, encounter));

    }

}
