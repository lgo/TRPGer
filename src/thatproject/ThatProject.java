package thatproject;

import thatproject.manager.MapManager;
import thatproject.manager.MonsterManager;
import thatproject.menu.Game;
import thatproject.menu.MainMenu;
import thatproject.readers.MapReader;
import thatproject.readers.MonsterReader;
import thatproject.readers.MovementReader;
import thatproject.util.Save;

public class ThatProject {

    public static String name = "ThatProject";
    public static int x = 700, y = 600;

    public static MapManager mapm = new MapManager(0, 0, 100, 100);
    public static MonsterManager monsterm = new MonsterManager(10);
    public static MainMenu m;

    public static MapReader mapr;
    public static MonsterReader monsterr;
    public static MovementReader mover;

    public static Save s = new Save();

    public static void main(String[] args) {
        MapReader.exec();
        MainMenu.exec();
        Game.start();
    }
}
