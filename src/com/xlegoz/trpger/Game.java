package com.xlegoz.trpger;

import com.xlegoz.trpger.entities.being.Enemy;
import com.xlegoz.trpger.entities.being.Player;
import com.xlegoz.trpger.gui.StandardMenu;
import com.xlegoz.trpger.readers.ItemReader;
import com.xlegoz.trpger.readers.MapReader;
import com.xlegoz.trpger.readers.MonsterReader;
import com.xlegoz.trpger.readers.MovementReader;
import com.xlegoz.trpger.readers.ZoneReader;
import com.xlegoz.trpger.script.Scripts;
import com.xlegoz.trpger.util.Save;
import com.xlegoz.trpger.world.World;

public class Game {

    //Declaring and Initializing public variables
    public static Player p;
    public static Enemy e;
    public static MapReader mapr;
    public static MonsterReader monsterr;
    public static MovementReader mover;
    public static ZoneReader zoner;
    public static ItemReader itemr;

    public static final int mapW = 100;
    public static final int mapH = 100;

    public static final int gameStartX = 3;
    public static final int gameStartY = 0;

    public static boolean loaded = false;
    public static boolean lost;
    public static boolean done = false;
    public static boolean win = false;

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
        postLoad();
        intro();
    }

    private static void postLoad() {

    }

    //Starts the readers for maps, zones, and others.
    private static void initFiles() {
        Scripts.exec();
        ZoneReader.exec();
        MapReader.exec();
        MovementReader.exec();
        ItemReader.exec();
        MonsterReader.exec();
    }

    //Sets the intro text to the screen of the main menu when starting the game
    private static void intro() {
        String n = TRPGer.name; //shorter than having to type the name every time
        String nl = "\n"; //shorter than writing "\n" every time
        String nl2 = "\n\n"; //again, shorter than putting "\n\n"
        World.startGame(gameStartX, gameStartY);
        StandardMenu.set("Welcome to the world of " + n + "!" + nl + n + " is a text based RPG where you must make your way through the inner depths to succeed in your quest." + nl + "To play you will type commands and press enter in the field below." + nl2 + "For starting off, type 'yes' to continue into the game, or 'no' to exit the game." + nl2 + "You may also type 'help' at any moment for a list of current usable commands and what they do. Alongside those are shorthand abbreviations for nearly all commands.");
        while (!TRPGer.itemsLoaded || !TRPGer.menuLoaded) {
            Thread.yield();
        }

    }

    //sets menu to say game over
    public static void gameover() {
        lost = true;
        StandardMenu.set("You have died! Game over.");
    }
}
