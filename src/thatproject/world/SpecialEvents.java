package thatproject.world;

import thatproject.actions.Attack;
import thatproject.menu.MainMenu;
import thatproject.util.Commands;

public class SpecialEvents {

    private static int stage = 0;
    private static boolean spider = false;
    private static int temp = 50;
    private static String active;

    public static void tutorialSpider() {
        Commands.specialEvent = true;
        spider = true;
        if (stage == 0) {
            MainMenu.set("Spider     <- This is the monsters name. Below is it's health points.\n");
            MainMenu.add(Attack.healthDisplay(50, 50, 20));
            MainMenu.addTemp("\n\nNow attack it by typing 'slash', one of the many attacks.");
            stage++;
        } else if (stage == 1) {
            if (active.equals("slash")) {
                int damage = Attack.attack(5, 10);
                temp -= damage;
                MainMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                MainMenu.add("\nYou slash away at the spider for " + damage + ".\n\n");
                MainMenu.addTemp("Great! You got a nasty blow on the Spider. In this tutorial the spider won't actually attack back, for the sake of learning. Now if you'd go ahead and give it a good 'stab' to continue that would be great.");
                stage++;
            } else {
                MainMenu.addTemp("\n\nYou didn't type 'slash'! Go ahead, try it out.");
            }
        } else if (stage == 2) {
            if (active.equals("stab")) {
                int damage = Attack.attack(15, 25);
                temp -= damage;
                MainMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                MainMenu.add("\nYou give the spider deep impale for " + damage + ".\n\n");
                MainMenu.addTemp("See how that did much more damage? That's because different attacks have different amounts of damage that it will induce. Go ahead and give the spider another 'stab'!");
                stage++;
            } else {
                MainMenu.addTemp("If you would like to survive, I highly advise you give 'stab' a go.");
            }
            
        } else if (stage == 3) {
            if (active.equals("stab")) {
                MainMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                MainMenu.add("\nYou lunge at the spider, but swiftly miss it with the dagger.\n\n");
                MainMenu.addTemp("That's the downside of more powerful attacks such as stab, they miss more often then attacks such as slash.\nThroughout this journey you will find what suits you as well as what your limits are. With this in mind, finish off the Spider with what you know.");
                stage++;
            } else {
                MainMenu.addTemp("If you really want to get going, you definitely need to give 'stab' another shot!");
            }
        }
        
        else if (temp > 0){
            //Spider killing events
        } else {

            Commands.specialEvent = false;
            spider = false;
        }
    }

    public static void command(String a) {
        active = a;
        if (spider) {
            tutorialSpider();
        }
    }

}
