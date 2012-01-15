package thatproject;

import thatproject.menu.Game;
import thatproject.menu.MainMenu;
import thatproject.readers.MapReader;
import thatproject.readers.MonsterReader;
import thatproject.util.Save;
import thatproject.world.MapManager;

public class ThatProject {

    public static String name = "ThatProject";
    public static int x = 700, y = 600;

    public static MapManager mm = new MapManager(0, 0, 100, 100);
    public static MainMenu m;

    public static MapReader mapr;
    public static MonsterReader monsterr;

    public static Save s = new Save();

    public static void main(String[] args) {
        MapReader.exec();
        MainMenu.exec();
        Game.start();
    }
}
