package thatproject.util;

import thatproject.Game;
import thatproject.manager.MapManager;
import thatproject.menu.MainMenu;
import thatproject.world.World;

public class Event {

    private static boolean drop = false;

    public static void accept() {

    }

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

    public static void update() {
        MainMenu.healthBar.setMaximum(Game.p.hpMax);
        MainMenu.healthBar.setValue(Game.p.hp);
        MainMenu.playerHP.setText("Health: " + Game.p.hp + "/" + Game.p.hpMax);
    }

    public static void move(int dir) {
        MapManager.Move(dir);
    }

    public static void buttonPress(int x, int y) {
        System.out.println(x + " : " + y);
    }

    public static void initiateGame() {
        World.currentMap.enter();
    }

    public static void initiateFirst() {
        MainMenu.set("You awaken, brandished of what has occured in recent moments. With complete amnesia you move forward to the edge of a tree, only to see a large spider drop down and prepare to pounce(LOLWUT?) onto you.\n\nDo you wish to engage it (Combat Tutorial)?");
    }
}
