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

    //Declaring and Initializing public variables
    public static Player p;
    public static MapReader mapr;
    public static MonsterReader monsterr;
    public static MovementReader mover;
    public static AttackReader attackr;
    public static ZoneReader zoner;

    public static World world = new World();

    public static final int mapW = 100;
    public static final int mapH = 100;

    public static final int gameStartX = 1;
    public static final int gameStartY = 2;

    public static boolean loaded = false;

    //Initial starting function to starting function
    public static void start() {
        init(); //calls init() function
    }

    //init() function calls initFiles(), creates a new Player and calls the load() function
    private static void init() {
        initFiles();
        p = new Player(Save.init());
        while (!loaded) {
            Thread.yield();
        }
        load();

    }
    
    //Calls intro() function
    private static void load() {
        intro();
    }

    //Starts the readers for maps, zones, and others.
    private static void initFiles() {
        ZoneReader.exec();
        MapReader.exec();
        MovementReader.exec();
        // MonsterReader.exec();
        // AttackReader.exec();
    }

    //Sets the intro text to the screen of the main menu when starting the game
    private static void intro() {
        String n = ThatProject.name; //shorter than having to type the name every time
        String nl = "\n"; //shorter than writing "\n" every time
        String nl2 = "\n\n"; //again, shorter than putting "\n\n"
        world.startGame(gameStartX, gameStartY);
        MainMenu.set("Welcome to the world of " + n + "!" + nl + n + " is a text based RPG where you must make your way through the inner depths to succeed in your quest." + nl + "To play you will type commands and press enter in the field below." + nl2 + "For starting off, type yes to continue into the game, or no to exit the game." + nl2 + "You may also type help at any moment for a list of current usable commands and what they do. Alongside those are shorthand abbreviations for nearly all commands.");

    }
}
