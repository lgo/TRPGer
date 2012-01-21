package thatproject.world;

import java.util.ArrayList;

public class Zone {
    private int zone;

    private Map[][] locations = new Map[5][5];

    private ArrayList<Integer> monster = new ArrayList<Integer>();

    private String name;
    private String[] generic_descriptions;

    public Zone(int z, String n, String[] d, int[] monsters) {
        zone = z;
        name = n;
        generic_descriptions = d;
        for (int monsterID : monsters) {
            monster.add(monsterID);
        }
    }

    public String getName() {
        return name;
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

}
