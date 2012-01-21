package thatproject.manager;

import thatproject.world.Map;

public class MapManager {

    private static Map[][] locations;
    private static Map currentLocation;
    private static int x, y;

    /**
     * Initialize the static variables
     * 
     * @param x of the player
     * @param y of the player
     * @param mapWidth of maps
     * @param mapLength of maps
     */
    public static void init(int x, int y, int mapWidth, int mapLength) {
        locations = new Map[mapWidth][mapLength];
        currentLocation = locations[x][y];
        MapManager.x = x;
        MapManager.y = y;
    }

    public static void populateWorlds(int x, int y, String name, String description, boolean[] directions, int zone) {
        locations[x][y] = new Map(x, y, name, description, directions, zone);
    }

    public static void insertMonster(int x, int y, int monster) {
        locations[x][y].insertMonster(monster);
    }

    public static void Move(int dir) {
        if (currentLocation.move(dir)) {
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
