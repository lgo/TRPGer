package com.xlegoz.trpger.manager;

import java.util.Random;

import com.xlegoz.trpger.actions.Movement;
import com.xlegoz.trpger.gui.StandardMenu;
import com.xlegoz.trpger.world.Inventory;
import com.xlegoz.trpger.world.Map;
import com.xlegoz.trpger.world.World;

public class MapManager {

    //loads map
    public static void populateWorlds(int z, int x, int y, boolean spawn, String description, boolean[] directions) {
        World.zones[z].insertMap(x, y, new Map(x, y, spawn, description, directions));
    }

    //gets monsters that can be spawned in that zone of the map.
    public static void insertMonster(int x, int y, int monster) {
        World.getZone().getMap(x, y).insertMonster(monster);
    }

    //changes map in specified direction
    public static void Move(int dir) {
        //if you can enter map, sends to next map
        if (World.currentMap.move(dir)) {
            Random generator = new Random();
            if (generator.nextInt(100) <= 20) {
                Inventory.getItem(Inventory.itemList.get(2));
            }
            World.currentMap.directionToMap(dir).enter(dir);
            //else calls wrong direction function
        } else {
            wrongDirection(dir);
        }
    }

    //tells player that they cannot go in the direction they were trying to go.
    private static void wrongDirection(int dir) {
        StandardMenu.addTemp("\nYou cannot go " + Movement.directionToString(dir) + " from here.");
    }

}
