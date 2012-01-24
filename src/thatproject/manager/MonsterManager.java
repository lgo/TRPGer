package thatproject.manager;

import java.util.ArrayList;
import java.util.Random;

import thatproject.entities.Monster;
import thatproject.entities.being.Enemy;
import thatproject.world.Map;
import thatproject.world.World;

public class MonsterManager {

    private static Random generator = new Random();

    private static ArrayList<Monster> monsters = new ArrayList<Monster>();
    private static Enemy currentBattle;

    public static void populateMonsters(int[] stats, String name, String description, String[] encounter, int[] zone) {
        // monsters.add(new Monster(stats, name, encounter));

    }

    public static void spawn(int dir, Map m) {
        if (generator.nextInt(100) <= World.getZone().getRate()) {
         //   System.out.println("SPAWN!");
           /*
            int monsterSpawn = generator.nextInt(100);
            int temp = 0;
            for (int m : World.getZone().getMonsters()) {
                if (monsterSpawn >= temp && monsterSpawn < monsters.get(m).getRate()) {
                    World.startCombat(monsters.get(m));
                } else {
                    temp += monsters.get(m).getRate();
                }
            } */
        }
        m.postCombat(dir);
    }

}
