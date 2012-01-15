package thatproject.menu;

import thatproject.ThatProject;
import thatproject.entities.being.Player;
import thatproject.util.Save;

public class Game {
    
    public static Player p;

    public static void start() {
        init();
        ThatProject.m.set("Welcome");
    }
    
    private static void init() {
        load();
    }
    
    private static void load() {
        p = new Player(Save.read());
        System.out.println("hi");
    }
}
