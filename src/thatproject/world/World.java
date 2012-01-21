package thatproject.world;


public class World {

    public static Zone[] zones;
    public static Map currentMap;
    public static int currentZone = 0;
    private static int x, y;

    public void startGame(int gamestartx, int gamestarty) {
        currentMap = zones[currentZone].getMap(gamestartx, gamestarty);
    }

    public Zone getZone() {
        return zones[currentZone];
    }

}
