package thatproject;

import thatproject.entities.being.Player;
import thatproject.menu.MainMenu;
import thatproject.readers.AttackReader;
import thatproject.readers.MapReader;
import thatproject.readers.MonsterReader;
import thatproject.readers.MovementReader;
import thatproject.readers.ZoneReader;
import thatproject.util.Save;
import thatproject.world.World;

public class Game {

    public static Player p;
    public static MapReader mapr;
    public static MonsterReader monsterr;
    public static MovementReader mover;
    public static AttackReader attackr;
    public static ZoneReader zoner;

    public static World world = new World();
    public static boolean loaded = false;

    public static final int mapW = 100;
    public static final int mapH = 100;

    public static final int gameStartX = 1;
    public static final int gameStartY = 2;

    public static void start() {
        init();
    }

    private static void init() {
        initFiles();
        p = new Player(Save.init());
        while(!loaded) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        load();

    }

    private static void load() {
        intro();
    }

    private static void initFiles() {
        ZoneReader.exec();
        MovementReader.exec();
        // MonsterReader.exec();
        // AttackReader.exec();
    }

    private static void intro() {
        world.startGame(gameStartX, gameStartY);
        MainMenu.set("Welcome to the world of " + ThatProject.name + "!\nHi!\n");
        // Movement.getMovement(World.currentMap, 1);
    }
}
