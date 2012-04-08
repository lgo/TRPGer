package com.xlegoz.trpger.world;

import java.util.ArrayList;

import com.xlegoz.trpger.Game;
import com.xlegoz.trpger.actions.Attack;
import com.xlegoz.trpger.actions.Movement;
import com.xlegoz.trpger.manager.MonsterManager;
import com.xlegoz.trpger.menu.StandardMenu;
import com.xlegoz.trpger.util.Commands;


public class Map {
    public int x;
    public int y;

    private ArrayList<Integer> monster = new ArrayList<Integer>();

    private String name;
    private String description;

    private boolean spawn;
    private boolean[] direction = new boolean[4];
    private static final String nl = "\n";

    //Create map without name
    public Map(int xLoc, int yLoc, boolean s, String d, boolean[] dir) {
        x = xLoc;
        y = yLoc;
        spawn = s;
        description = d;
        direction = dir;
    }

    //Create map with name
    public Map(String n, int xLoc, int yLoc, boolean s, String d, boolean[] dir) {
        name = n;
        x = xLoc;
        y = yLoc;
        spawn = s;
        description = d;
        direction = dir;
    }

    //Return map name (If none return generic name)
    public String getName() {
        return name == null ? World.getZone().getName() : name;
    }

    //Inster monster into arraylist
    public void insertMonster(int id) {
        monster.add(id);
    }

    //Return if that direction is moveable
    public boolean move(int dir) {
        return direction[dir];
    }

    //Return all directions moveable
    public boolean[] move() {
        return direction;
    }

    //Enter this map, with direction integer for custom output
    public void enter(int dir) {
        World.currentMap = this;
        if (spawn) {
            MonsterManager.spawn(dir, this);
        } else {
            postSpawn(dir);
        }
    }

    //Call post combat functions
    public void postCombat(int dir) {
        postSpawn(dir);
    }

    //Execute post spawn stuff
    public void postSpawn(int dir) {
        StandardMenu.set(Movement.getMovement(this, dir) + enter(true));
    }

    //Set entery info
    public void enter() {
        StandardMenu.set(description);
        StandardMenu.add(travelDirections());
    }

    //Return entry info
    public String enter(boolean override) {
        return description + travelDirections();

    }

    //Return strings for each direction travellable and prints upon no map avialable in that direction
    private String travelDirections() {
        String r = "";
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

    //Check if certian location is a map
    public boolean isMap(int xLoc, int yLoc) {
        return x == xLoc && y == yLoc ? true : false;
    }

    //Get the mapzone of the given direction
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

    //Initiate combat with enemy
    public void startCombat(int dir) {
        Commands.gameState = 2;
        World.nextMap = this;
        World.nextMapInt = dir;
        StandardMenu.set(Attack.attackDisplay(Game.e, Attack.SPACES));
        StandardMenu.add(nl + Game.e.encounter);

    }
}
