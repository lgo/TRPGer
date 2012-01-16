package thatproject;

import thatproject.menu.Game;
import thatproject.menu.MainMenu;
import thatproject.util.Save;

public class ThatProject {

    public static String name = "ThatProject";
    public static int x = 700, y = 600;

    public static MainMenu m;

    public static Save s = new Save();

    public static void main(String[] args) {
        MainMenu.exec();
        Game.start();
    }
}
