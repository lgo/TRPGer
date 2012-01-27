package thatproject.world;

import java.util.ArrayList;

public class Zone {
    private int zone;

    private Map[][] locations = new Map[7][7];

    private ArrayList<Integer> monster = new ArrayList<Integer>();
    private int spawn_rate;

    private String name;
    private String[] generic_descriptions;

    //Zone constructor
    public Zone(int z, String n, String[] d, int[] monsters, int rate) {
        zone = z;
        name = n;
        generic_descriptions = d;
        for (int monsterID : monsters) {
            monster.add(monsterID);
        }
        spawn_rate = rate;
    }

    //Get name of zone
    public String getName() {
        return name;
    }

    //Get spawn rate of zone
    public int getRate() {
        return spawn_rate;
    }

    //Insert monsters to spawn in this zone
    public void insertMonster(int id) {
        monster.add(id);
    }

    //Insert maps into this zones area
    public void insertMap(int x, int y, Map m) {
        locations[x][y] = m;
    }

    //Get certian map object
    public Map getMap(int x, int y) {
        return locations[x][y];
    }

    //Get a list of the monsters that spawn here
    public int[] getMonsters() {
        int[] m = new int[monster.size()];
        for (int i = 0; i < monster.size(); i++) {
            m[i] = monster.get(i);
        }
        return m;
    }

}
