package thatproject.world;

import thatproject.entities.Monster;
import thatproject.entities.being.Enemy;

public class World {

    public static Zone[] zones;
    public static Map currentMap;
    public static int currentZone = 0;
    private static int x, y;

    public static void startGame(int gamestartx, int gamestarty) {
        currentMap = getZone().getMap(gamestartx, gamestarty);
        x = gamestartx;
        y = gamestarty;
    }

    public static Zone getZone() {
        return zones[currentZone];
    }

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

    public static void start() {
        currentMap.enter();
    }

    public static void startCombat(Monster monster) {
        Enemy e = new Enemy(monster);
        System.out.println(e.name);
    }

}
