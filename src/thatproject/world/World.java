package thatproject.world;


public class World {

    public Zone[] zones;
    public Map currentMap;
    public int currentZone = 0;
    private int x, y;

    public void startGame(int gamestartx, int gamestarty) {
        currentMap = zones[currentZone].getMap(gamestartx, gamestarty);
    }

    public Zone getZone() {
        return zones[currentZone];
    }

}
