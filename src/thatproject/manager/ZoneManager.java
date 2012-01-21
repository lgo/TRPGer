package thatproject.manager;

import thatproject.Game;

public class ZoneManager {

    public static void insertMonster(int z, int monster) {
        Game.world.zones[z].insertMonster(monster);
    }

}
