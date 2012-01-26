package thatproject.manager;

import java.util.ArrayList;
import java.util.Random;

import thatproject.Game;
import thatproject.entities.Monster;
import thatproject.entities.being.Enemy;
import thatproject.world.Map;
import thatproject.world.World;

public class MonsterManager {

    //creates generator for use other than double
    private static Random generator = new Random();

    //creates array list for monsters
    private static ArrayList<Monster> monsters = new ArrayList<Monster>();

    //function to generate which monster is spawned and calls startCombat()
    public static void spawn(int dir, Map m) {
        try {
            //generates random number and compares to rate of spawn
            if (generator.nextInt(100) <= World.getZone().getRate()) {
                int monsterSpawn = generator.nextInt(100);
                int temp = 0;
                //for loop to add to temp for comparing spawn to temp until spawn <= temp, then gets monster info
                for (int monster : World.getZone().getMonsters()) {
                    if (monsterSpawn >= temp && monsterSpawn <= (temp += monsters.get(monster).getRate())) {
                        System.out.println(monsters.get(monster).name);
                        Game.e = new Enemy(monsters.get(monster)); //Creates Enemy

                        m.startCombat(dir);
                    }

                }

            } else {
                m.postSpawn(dir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //adds, monster's stats to the array so the Enemy can have the same stats.
    public static void populateMonsters(String name, int rate, int health, int[] stats, int[] itemDrops, String encounter) {
        monsters.add(new Monster(name, rate, health, stats, itemDrops, encounter));
    }

}
