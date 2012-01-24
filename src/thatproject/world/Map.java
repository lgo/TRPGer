package thatproject.world;

import java.util.ArrayList;

import thatproject.actions.Movement;
import thatproject.manager.MonsterManager;
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

    public Map(String n, int xLoc, int yLoc, boolean s, String d, boolean[] dir) {
        name = n;
        x = xLoc;
        y = yLoc;
        spawn = s;
        description = d;
        direction = dir;
    }

    public String getName() {
        return name == null ? World.getZone().getName() : name;
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
        World.currentMap = this;
        if (spawn) {
            // System.out.println("Combat text!");
            MonsterManager.spawn(dir, this);
        } else {
            postSpawn(dir);
        }
    }

    public void postCombat(int dir) {
        // System.out.println("Post combat texties");//TODO post combat text
        postSpawn(dir);
    }

    public void postSpawn(int dir) {
        MainMenu.set(Movement.getMovement(World.getZone().getMap(x, y), dir) + enter(true));
    }

    public void enter() {
        MainMenu.set(description);
        MainMenu.add(travelDirections());
    }

    public String enter(boolean override) {
        System.out.println(x + ":" + y);
        return description + travelDirections();

    }

    private String travelDirections() {
        String r = "";
        World.getZone().diag();
        // System.out.println("travel");

        for (int i = 0; i < 4; i++) {
            if (direction[i]) {
                try {
                    r += "\nYou can travel " + Movement.directionToString(i) + " from here towards a " + directionToMap(i).getName();
                } catch (Exception e) {
                    System.out.println("Something is wrong with the map directions! " + x + ":" + y);
                }

            }
        }
        return r;
    }
    
    public boolean isMap(int xLoc, int yLoc) {
        return x == xLoc && y == yLoc ? true : false;
    }

    public Map directionToMap(int dir) {
        Map temp = null;
        switch (dir) {
            case 0:
                temp = World.getZone().getMap(x - 1, y);
                break;
            case 1:
                temp = World.getZone().getMap(x + 1, y);
                break;
            case 2:
                temp = World.getZone().getMap(x, y + 1);
                break;
            case 3:
                temp = World.getZone().getMap(x, y - 1);
                break;
        }
        return temp;
    }
}
