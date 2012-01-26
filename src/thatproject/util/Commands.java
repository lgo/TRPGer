package thatproject.util;

import thatproject.Game;
import thatproject.actions.Attack;
import thatproject.menu.MainMenu;
import thatproject.world.Inventory;
import thatproject.world.SpecialEvents;
import thatproject.world.World;

public class Commands {

    public static int gameState = 0;

    private static String[] attacks = { "slash", "stab", "crush" };
    private static String[] accept = { "yes", "y", "okay", "k" };
    private static String[] deny = { "no", "n" };
    private static String[] directions = { "n", "s", "e", "w", "north", "south", "east", "west" };

    private static int count = 0;

    private static String active;

    public static boolean specialEvent = false;

    public static void command(String s) {
        active = s.toLowerCase();
        if (Game.done)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            return;
    }
        if (specialEvent) {
            SpecialEvents.command(active);
        }
        switch (gameState) {
            case 0:
                startState();
                break;
            case 1:
                mapState();
                break;
            case 2:
                battleState();
                break;
            case 3:
                statState();
                break;
        }

        // Globals
        if (active.equals("help")) {
            help();
        } else if (active.equals("potion")) {
            Inventory.getItem(Inventory.itemList.get(2));
        } else if (active.equals("debug")) {
            Game.p.str = 9001;
        }

        if (World.currentMap.isMap(4, 5)) {
            if (!Inventory.haveItem(Inventory.itemList.get(0))) {
            MainMenu.addTemp("\nYou've found a Skeleton Key pertrueding from a branch.");
            Inventory.getItem(Inventory.itemList.get(0));
            }
        }

        if (World.currentMap.isMap(0, 3)) {
            if (Inventory.haveItem(Inventory.itemList.get(0))) {
                Game.win = true;
                MainMenu.addTemp("\nYOU WON!");
            } else {
                MainMenu.addTemp("\nYOU LOST!");
            }
            Game.done = true;
            Commands.command(null);
        }

    }

    private static void statState() {
        if (active.equals("exit")) {
            gameState = 1;
        }
    }

    private static void battleState() {
        if (check(attacks)) {
            attack();
        } else if (active.equals("continue") || active.equals("c")) {
            gameState = 1;
            World.currentMap.postCombat(World.nextMapInt);
        }
    }

    private static void mapState() {
        if (check(accept)) {
            Event.accept();
        } else if (active.equals("drop")) {
            Event.drop(true);
        } else if (active.equals("cancel")) {
            Event.drop(false);
        } else if (check(directions)) {
            int dir = 0;
            if (active.equals("n") || active.equals("north")) {
                dir = 0;
            } else if (active.equals("s") || active.equals("south")) {
                dir = 1;
            } else if (active.equals("e") || active.equals("east")) {
                dir = 2;
            } else if (active.equals("w") || active.equals("west")) {
                dir = 3;
            }
            Event.move(dir);
        } else if (check(new String[] { "stat", "stats" })) {

        } else if (active.equals("rest") && World.currentMap.isMap(3, 0)) {
            MainMenu.addTemp("\nYou have rested here, your HP and Stamina have regenerated.");
            Game.p.hp = Game.p.hpMax;
            MainMenu.refreshHP();

        }

    }

    private static void startState() {
        switch (count) {
            case 0:
                if (check(accept)) {
                    Event.initiateFirst();
                    count++;
                } else if (check(deny)) {
                    System.exit(0);
                }
                break;
            case 1:
                if (check(accept)) {
                    SpecialEvents.tutorialSpider();
                    gameState = 1;
                } else if (check(deny)) {
                    World.start();
                    gameState = 1;
                }
                break;
        }

    }

    private static boolean check(String[] a) {
        for (String temp : a) {
            if (active.equals(temp))
                return true;
        }
        return false;
    }

    private static void attack() {
        for (int i = 0; i < attacks.length; i++) {
            if (active.equals(attacks[i])) {
                Attack.attack(i);
            }
        }
    }

    private static void help() {
        String t = "\n";
        switch (gameState) {
            case 1:
                boolean[] temp = World.currentMap.move();
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i] == true) {
                        t += "\n";
                        switch (i) {
                            case 0:
                                t += "n - Travel Sorth";
                                break;
                            case 1:
                                t += "s - Travel South";
                                break;
                            case 2:
                                t += "e - Travel East";
                                break;
                            case 3:
                                t += "w - Travel West";
                                break;
                        }
                    }
                }
                break;
            case 2:
                t += "slash - Attack for 70% damage and 100% hit rate";
                t += "stab - Attack for 100% damage and 70% hit rate";
                t += "crush - Attack for 120% damage and 50% hit rate";
                break;
            case 3:
                break;
        }
        MainMenu.addTemp(t);
    }

    /**
     * Inserts string into attack array
     * 
     * @param attack string to insert
     */
    public static void insertAttack(String attack) {
        attacks[attacks.length] = attack;
    }

    /**
     * Setup the attacks array with the appropriate size
     * 
     * @param size for the array
     */
    public static void attackSize(int size) {
        attacks = new String[size];
    }

}
