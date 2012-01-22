package thatproject.world;

import thatproject.actions.Attack;
import thatproject.menu.MainMenu;
import thatproject.util.Commands;

public class SpecialEvents {

    private static int stage = 0;
    private static boolean spider = false;
    private static int temp = 50;

    public static void tutorialSpider() {
        Commands.specialEvent = true;
        spider = true;
        if (stage == 0) {
            MainMenu.set(Attack.attackDisplay(50, 50, 20, "Spider"));
            stage++;
        } else if (stage == 1) {
        } else if (stage == 2) {
        } else {
            Commands.specialEvent = false;
            spider = false;
        }
    }

    public static void command(String active) {
        if (spider) {
            tutorialSpider();
        }
    }

}
