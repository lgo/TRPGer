package thatproject.world;

public class MapManager {

    private static Map[][] locations;
    private static Map currentLocation;

    public MapManager(int x, int y, int mapWidth, int mapLength) {
        locations = new Map[mapWidth][mapLength];
        currentLocation = locations[x][y];
    }

    public void populateWorlds(int x, int y, String name, String description, boolean[] directions, int zone) {
        locations[x][y] = new Map(x, y, name, description, directions, zone);
    }

}
