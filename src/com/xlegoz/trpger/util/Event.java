package com.xlegoz.trpger.util;

import com.xlegoz.trpger.gui.StandardMenu;
import com.xlegoz.trpger.manager.MapManager;
import com.xlegoz.trpger.world.Inventory;
import com.xlegoz.trpger.world.World;

public class Event {

    //declare drop variable
    private static boolean drop = false;

    public static void accept() {

    }

    //not implemented due to lack of time
    public static void drop(boolean dropmode) {
        if (dropmode) {
            if (drop) {

            } else if (!drop) {

            }
        } else if (!dropmode) {
            if (drop) {

            } else if (!drop) {

            }
        }
    }

    //calls move function to change maps
    public static void move(int dir) {
        MapManager.Move(dir);
    }

    //calls use function if item exists in inventory
    public static void buttonPress(int x, int y) {
        if (Inventory.exists(x, y)) {
            Inventory.useItem(x, y);
        }
    }

    //to initiate game map
    public static void initiateGame() {
        World.currentMap.enter();
    }

    //sets opening text after starting game
    public static void initiateFirst() {
        StandardMenu.set("You awaken, brandished of what has occured in recent moments. With complete amnesia you move forward to the edge of a tree, only to see a large spider drop down and prepare to pounce(LOLWUT?) onto you.\n\nDo you wish to engage it (Combat Tutorial)?");
    }
}
