package thatproject.manager;

import thatproject.world.Zone;

public class ZoneManager {

    private static Zone[] locations;
    private static Zone currentLocation;
    private static int z;

    /**
     * Initialize the static variables
     * 
     * @param x of the player
     * @param y of the player
     * @param mapWidth of maps
     * @param mapLength of maps
     */
    public static void init(int amount, int z) {
        locations = new Zone[amount];
        currentLocation = locations[z];
        ZoneManager.z = z;
    }

    public static void populateZones(int z, String name, String description) {
        locations[z] = new Zone(z, name, description);
    }

    public static void insertMonster(int z, int monster) {
        locations[z].insertMonster(monster);
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
