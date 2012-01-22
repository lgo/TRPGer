package thatproject.manager;

import thatproject.world.World;

public class ZoneManager {

    public static void insertMonster(int z, int monster) {
        World.zones[z].insertMonster(monster);
    }

}
