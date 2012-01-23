package thatproject.world;

import java.util.ArrayList;

public class Map {
    private int x;
    private int y;

    private ArrayList<Integer> monster = new ArrayList<Integer>();

    private String name;
    private String description;

    private boolean[] direction = new boolean[4];

    public Map(int xLoc, int yLoc, String n, String d, boolean[] dir) {
        x = xLoc;
        y = yLoc;
        name = n;
        description = d;
        direction = dir;
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
    
    public boolean[] move() {
        return direction;
    }

    public void enter() {

    }

}
