package com.xlegoz.trpger;

import com.xlegoz.trpger.menu.StandardMenu;


public class TRPGer {

    //declaring variables and initializing their values.
    public static String name = "Absolute Power";
    public static int x = 900, y = 600; //dimensions of game window

    public static StandardMenu m;

    public static boolean threadFreeze = true;
    public static boolean menuLoaded = false;
    public static boolean itemsLoaded = false;

    //Main function which starts executes the main menu and starts the game.
    public static void main(String[] args) {
        try {

            StandardMenu.exec();
            Game.start();
        }
        //Catches error and prints it.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
