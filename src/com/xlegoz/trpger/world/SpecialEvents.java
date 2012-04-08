package com.xlegoz.trpger.world;

import com.xlegoz.trpger.actions.Attack;
import com.xlegoz.trpger.gui.StandardMenu;
import com.xlegoz.trpger.util.Commands;

public class SpecialEvents {

    private static int stage = 0;
    private static boolean spider = false;
    private static int temp = 50;
    private static String active;

    //All tutorial spider stuff, going in order of each stage of the tutorial
    //Mostly just lots of text to display
    public static void tutorialSpider() {
        Commands.specialEvent = true;
        spider = true;
        if (stage == 0) {
            StandardMenu.set("Spider     <- This is the monsters name. Below is it's health points.\n");
            StandardMenu.add(Attack.healthDisplay(50, 50, 20));
            StandardMenu.addTemp("\n\nNow attack it by typing 'slash', one of the many attacks.");
            stage++;
        } else if (stage == 1) {
            if (active.equals("slash")) {
                int damage = Attack.attack(5, 10);
                temp -= damage;
                StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                StandardMenu.add("\nYou slash away at the spider for " + damage + ".\n\n");
                StandardMenu.addTemp("Great! You got a nasty blow on the Spider. In this tutorial the spider won't actually attack back, for the sake of learning. Now if you'd go ahead and give it a good 'stab' to continue that would be great.");
                stage++;
            } else {
                StandardMenu.addTemp("\n\nYou didn't type 'slash'! Go ahead, try it out.");
            }
        } else if (stage == 2) {
            if (active.equals("stab")) {
                int damage = Attack.attack(15, 25);
                temp -= damage;
                StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                StandardMenu.add("\nYou give the spider a deep impale for " + damage + ".\n\n");
                StandardMenu.addTemp("See how that did much more damage? That's because different attacks have different amounts of damage that it will induce. Go ahead and give the spider another 'stab'!");
                stage++;
            } else {
                StandardMenu.addTemp("If you would like to survive, I highly advise you give 'stab' a go.");
            }

        } else if (stage == 3) {
            if (active.equals("stab")) {
                StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                StandardMenu.add("\nYou lunge at the spider, but swiftly miss it with the dagger.\n\n");
                StandardMenu.addTemp("That's the downside of more powerful attacks such as stab, they miss more often then attacks such as slash.\n\nThroughout this journey you will find what suits you as well as what your limits are. With this in mind, finish off the Spider with what you know.");
                stage++;
            } else {
                StandardMenu.addTemp("If you really want to get going, you definitely need to give 'stab' another shot!");
            }
        }

        else if (temp > 0) {
            if (active.equals("stab")) {
                int damage = Attack.attack(10, 25);
                temp -= damage;
                if (temp <= 0) {

                    StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                    StandardMenu.add("\nYou give the spider a deep impale for " + damage + " and finish it off!\n\n");
                    StandardMenu.add("Congragulations, you have killed your first monster! Now that you have the basics of combat you're ready to delve into adventures! Type 'continue' to move on.");
                    spiderEnd();
                } else {
                    StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                    StandardMenu.add("\nYou give the spider a deep impale for " + damage + ".\n\n");
                }
            } else if (active.equals("slash")) {
                int damage = Attack.attack(5, 10);
                temp -= damage;
                if (temp <= 0) {

                    StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                    StandardMenu.add("\nYou slash away at the spider for " + damage + " and finish it off!\n\n");
                    StandardMenu.add("Congragulations, you have killed your first monster! Now that you have the basics of combat you're ready to delve into adventures! Type 'continue' to move on.");
                    spiderEnd();
                } else {
                    StandardMenu.set(Attack.attackDisplay(temp, 50, Attack.SPACES, "Spider"));
                    StandardMenu.add("\nYou slash away at the spider for " + damage + ".\n\n");
                }
            } else {
                StandardMenu.addTemp("If you keep this up the Spider will end up attacking you!");
            }
        }
    }

    //End the spider events
    private static void spiderEnd() {
        SpecialEvents.spider = false;
    }

    //Retrieve info for executing special events
    public static void command(String a) {
        active = a;
        if (spider) {
            tutorialSpider();
        } else if (active.equals("continue")) {
            Commands.specialEvent = false;
            World.start();
        }
    }

}
