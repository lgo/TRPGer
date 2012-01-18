package thatproject.menu;

import thatproject.ThatProject;
import thatproject.entities.being.Player;
import thatproject.manager.MapManager;
import thatproject.readers.AttackReader;
import thatproject.readers.MapReader;
import thatproject.readers.MonsterReader;
import thatproject.readers.MovementReader;
import thatproject.util.Save;

public class Game {

    public static Player p;
    public static MapReader mapr;
    public static MonsterReader monsterr;
    public static MovementReader mover;
    public static AttackReader attackr;

    public static final int mapW = 100;
    public static final int mapH = 100;
    
    public static final int gameStartX = 3;
    public static final int gameStartY = 0;

    public static void start() {
        init();
    }

    private static void init() {
        initFiles();
        load();

    }

    private static void load() {
        p = new Player(Save.init());
        MapManager.init(0, 0, 100, 100);
        intro();
    }

    private static void initFiles() {
        MapReader.exec();
        MovementReader.exec();
        // MonsterReader.exec();
        // AttackReader.exec();
    }

    private static void intro() {
        MainMenu.set("Welcome to the world of " + ThatProject.name + "!\nHi!");
    }
}
