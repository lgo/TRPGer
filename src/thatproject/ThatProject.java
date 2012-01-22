package thatproject;

import thatproject.menu.MainMenu;

public class ThatProject {

    public static String name = "Absolute Power";
    public static int x = 900, y = 600;

    public static MainMenu m;

    public static boolean threadFreeze = true;

    public static void main(String[] args) {
        try {

            MainMenu.exec();
            Game.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
