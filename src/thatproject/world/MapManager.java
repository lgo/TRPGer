package thatproject.world;

public class MapManager {
    
    private static Map[][] locations;
    private static Map currentLocation;
    
    public MapManager(int x, int y) {
        locations = new Map[x][y];
    }
    
    public void populateWorlds(int x, int y, String name, String description, boolean[] directions) {
        locations[x][y] = new Map(x, y, name, description, directions);
    }
    
    
}
