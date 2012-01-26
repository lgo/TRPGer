package thatproject.manager;

import thatproject.world.World;

public class ZoneManager {

    //Places monster in zone for spawning.
    public static void insertMonster(int z, int monster) {
        World.zones[z].insertMonster(monster);
    }

}
