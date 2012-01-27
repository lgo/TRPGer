package thatproject.world;

public class World {

    public static Zone[] zones;
    public static Map currentMap;
    public static int currentZone = 0;
    private static int x, y;
    public static Map nextMap;
    public static int nextMapInt;

    //Setup varaibles for starting the game
    public static void startGame(int gamestartx, int gamestarty) {
        currentMap = getZone().getMap(gamestartx, gamestarty);
        x = gamestartx;
        y = gamestarty;
    }

    //Get the current zone player is in
    public static Zone getZone() {
        return zones[currentZone];
    }

    //Change varible according to movement
    public static void move(int dir) {
        switch (dir) {
            case 0:
                y += 1;
                break;
            case 1:
                y -= 1;
                break;
            case 2:
                x += 1;
                break;
            case 3:
                x -= 1;
                break;
        }
        currentMap = getZone().getMap(x, y);
    }

    //Game starting function calling
    public static void start() {
        currentMap.enter();
    }

}
