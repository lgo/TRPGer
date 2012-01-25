package thatproject.manager;

import java.util.ArrayList;
import java.util.Random;

import thatproject.Game;
import thatproject.entities.Monster;
import thatproject.entities.being.Enemy;
import thatproject.world.Map;
import thatproject.world.World;

public class MonsterManager {

    private static Random generator = new Random();

    private static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public static void spawn(int dir, Map m) {
        try {
        if (generator.nextInt(100) <= World.getZone().getRate()) {
            int monsterSpawn = generator.nextInt(100);
            int temp = 0;
            for (int monster : World.getZone().getMonsters()) {
                if (monsterSpawn >= temp && monsterSpawn <= (temp += monsters.get(monster).getRate())){
                    System.out.println(monsters.get(monster).name);
                    Game.e = new Enemy(monsters.get(monster));
                }
                
            }

        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        m.startCombat(dir);
    }

    public static void populateMonsters(String name, int rate, int health, int[] stats, int[] itemDrops, String encounter) {
        monsters.add(new Monster(name, rate, health, stats, itemDrops, encounter));
    }

}
