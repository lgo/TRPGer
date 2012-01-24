package thatproject.manager;

import thatproject.actions.Movement;
import thatproject.menu.MainMenu;
import thatproject.world.Map;
import thatproject.world.World;

public class MapManager {

    public static void populateWorlds(int z, int x, int y, boolean spawn, String description, boolean[] directions) {
        World.zones[z].insertMap(x, y, new Map(x, y, spawn, description, directions));
    }

    public static void insertMonster(int x, int y, int monster) {
        World.getZone().getMap(x, y).insertMonster(monster);
    }

    public static void Move(int dir) {
        if (World.currentMap.move(dir)) {
            initiateMap(dir);
        } else {
            wrongDirection(dir);
        }
    }

    private static void wrongDirection(int dir) {
        MainMenu.addTemp("You cannot go " + Movement.directionToString(dir) + " from here.");
    }

    private static void initiateMap(int dir) {
        World.move(dir);
        MainMenu.add(Movement.getMovement(World.currentMap, dir));
    }

}
