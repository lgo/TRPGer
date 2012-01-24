package thatproject.world;

import java.util.ArrayList;

import thatproject.actions.Movement;
import thatproject.menu.MainMenu;

public class Map {
    private int x;
    private int y;

    private ArrayList<Integer> monster = new ArrayList<Integer>();

    private String name;
    private String description;

    private boolean spawn;
    private boolean[] direction = new boolean[4];

    public Map(int xLoc, int yLoc, boolean s, String d, boolean[] dir) {
        x = xLoc;
        y = yLoc;
        spawn = s;
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

    public void enter(int dir) {
        if (spawn) {

        } else {
            postSpawn(dir);
        }
    }

    public void postSpawn(int dir) {
        MainMenu.set(Movement.getMovement(World.getZone().getMap(x, y), dir) + description);
    }

    public void enter() {
        MainMenu.set(description);
        MainMenu.add(travelDirections());
    }

    private String travelDirections() {
        String r = "";
        for (int i = 0; i < 4; i++) {
            if (direction[i]) {
                
            }
        }
        return r;
    }
}
