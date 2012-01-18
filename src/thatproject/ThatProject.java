package thatproject;

import thatproject.menu.Game;
import thatproject.menu.MainMenu;

public class ThatProject {

    public static String name = "ThatProject";
    public static int x = 700, y = 600;

    public static MainMenu m;
    
    public static boolean threadFreeze;

    public static void main(String[] args) {
        try {
            
        
        MainMenu.exec();
        Game.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
