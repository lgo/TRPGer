package thatproject.world;

import java.util.ArrayList;

public class Zone {
    private int x;
    private int y;
    private int zone;

    private ArrayList<Integer> monster = new ArrayList<Integer>();

    private String name;
    private String description;

    private boolean[] direction = new boolean[4];

    public Zone(int xLoc, String n, String d) {
        x = xLoc;
        name = n;
        description = d;
    }

    public String getName() {
        return name;
    }

    public void insertMonster(int id) {
        monster.add(id);
    }

    public boolean move(int dir) {
        return direction[dir];
    }

}
