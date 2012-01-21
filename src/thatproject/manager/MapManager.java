package thatproject.manager;

import thatproject.Game;
import thatproject.world.Map;

public class MapManager {

    public static void populateWorlds(int z, int x, int y, String name, String description, boolean[] directions) {
        Game.world.zones[z].insertMap(x, y, new Map(x, y, name, description, directions));
    }

    public static void insertMonster(int x, int y, int monster) {
        Game.world.getZone().getMap(x, y).insertMonster(monster);
    }

    public static void Move(int dir) {
        if (Game.world.currentMap.move(dir)) {
            initiateMap();
        } else {
            wrongDirection(dir);
        }
    }

    private static void wrongDirection(int dir) {

    }

    private static void initiateMap() {

    }

}
