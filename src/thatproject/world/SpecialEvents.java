package thatproject.world;

import thatproject.menu.MainMenu;
import thatproject.util.Commands;

public class SpecialEvents {

    private static int stage = 0;
    private static boolean spider = false;

    public static void tutorialSpider() {
        Commands.specialEvent = true;
        spider  = true;
        if (stage == 0) {
            MainMenu.set("You carefully engage the spider in battle. TODO BATTLE, ATTACK DISPLAY");
            stage++;
        } else if (stage == 1) {
            stage++;
        } else if (stage == 2) {

        } else {
            Commands.specialEvent = false;
            spider = false;
        }
    }

    public static void command(String active) {
        if (spider) tutorialSpider();
    }

}
