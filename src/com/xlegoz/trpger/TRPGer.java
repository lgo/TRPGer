package com.xlegoz.trpger;

import com.xlegoz.trpger.gui.StandardMenu;


public class TRPGer {

    public static final boolean debug = true;
    
    public static String name;
    public static int x = 900, y = 600;

    public static StandardMenu m;

    public static boolean threadFreeze = true;
    public static boolean menuLoaded = false;
    public static boolean itemsLoaded = false;
    
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
