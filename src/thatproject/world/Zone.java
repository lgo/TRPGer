package thatproject.world;

import java.util.ArrayList;

public class Zone {
    private int zone;

    private Map[][] locations = new Map[7][7];

    private ArrayList<Integer> monster = new ArrayList<Integer>();
    private int spawn_rate;

    private String name;
    private String[] generic_descriptions;

    public Zone(int z, String n, String[] d, int[] monsters, int rate) {
        zone = z;
        name = n;
        generic_descriptions = d;
        for (int monsterID : monsters) {
            monster.add(monsterID);
        }
        spawn_rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return spawn_rate;
    }

    public void insertMonster(int id) {
        monster.add(id);
    }

    public void insertMap(int x, int y, Map m) {
        locations[x][y] = m;
    }

    public Map getMap(int x, int y) {
        return locations[x][y];
    }

    public int[] getMonsters() {
        int[] m = new int[monster.size()];
        for (int i = 0; i < monster.size(); i++) {
            m[i] = monster.get(i);
        }
        return m;
    }

    public void diag() {
        System.out.println("");
    }

}
