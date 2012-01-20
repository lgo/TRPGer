package thatproject.util;

import thatproject.manager.MapManager;
import thatproject.menu.Game;
import thatproject.menu.MainMenu;

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
}
