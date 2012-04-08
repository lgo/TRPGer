package com.xlegoz.trpger.util;


import com.xlegoz.trpger.Game;
import com.xlegoz.trpger.actions.Attack;
import com.xlegoz.trpger.menu.MainMenu;
import com.xlegoz.trpger.world.Inventory;
import com.xlegoz.trpger.world.SpecialEvents;
import com.xlegoz.trpger.world.World;

public class Commands {

    //declaring and initializing variables
    public static int gameState = 0;

    private static String[] attacks = { "slash", "stab", "crush" };
    private static String[] accept = { "yes", "y", "okay", "k" };
    private static String[] deny = { "no", "n" };
    private static String[] directions = { "n", "s", "e", "w", "north", "south", "east", "west" };

    private static int count = 0;

    private static String active;

    public static boolean specialEvent = false;

    //If Game.done then waits 2 seconds before calling calling function st00fz 
    public static void command(String s) {
        active = s.toLowerCase();
        //if special event calls special event.
        if (specialEvent) {
            SpecialEvents.command(active);
        } else if (Game.done) {
            if (active.equals("continue")) {
                MainMenu.setGameEnd(Game.win);
            }
            return;
        }
        //depending on gamestate, calls certain function
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

        // if you enter the map specified you gain a skeleton key in your inventory
        if (World.currentMap.isMap(4, 5)) {
            if (!Inventory.haveItem(Inventory.itemList.get(0))) {
                MainMenu.addTemp("\nYou've found a Skeleton Key pertrueding from a branch.");
                Inventory.getItem(Inventory.itemList.get(0));
            }
        }

        // if you enter this map without the key you lose, if you have it, you win.
        if (World.currentMap.isMap(0, 3)) {
            if (Inventory.haveItem(Inventory.itemList.get(0))) {
                Game.win = true;
            }
            Game.done = true;
            MainMenu.set("");
            if (Game.win) {
                Inventory.removeItem(Inventory.itemList.get(0));
                MainMenu.add("The forest opens to a clearing and you see a door in the midst. Looking at your hand the Skeleton Key resembles the emblem on the door and you inject it into the keyhole.\n\n");
            }
            MainMenu.add("The sky has gone dark and you stand alone with a hooded figure holding an imposing gun. He walks up to you shoots you before " + (Game.win ? "leaving through the door you opened with the Skeleton key. You majestically feel yourself enter a near flying state as you weightlessly drift off." : "opening a door in the midst with a peculiar key, vanishing through the frame. You instantaneously feel yourself fall down with the weight of a cinder block."));
            MainMenu.add("\n\nType 'continue' to move on in life.");
        }

    }

    // UNUSED - NOT IMPLEMENTED
    private static void statState() {
        if (active.equals("exit")) {
            gameState = 1;
        }
    }

    //Specific command checks for attacks
    private static void battleState() {
        if (check(attacks)) {
            attack();
        } else if (active.equals("continue") || active.equals("c")) {
            gameState = 1;
            World.currentMap.postCombat(World.nextMapInt);
        }
    }

    //Specific command checks for maps
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
            //NOT USED
        } else if (active.equals("rest") && World.currentMap.isMap(3, 0)) {//Check if on spawn and used rest for resting
            MainMenu.addTemp("\nYou have rested here, your HP and Stamina have regenerated.");
            Game.p.hp = Game.p.hpMax;
            MainMenu.refreshHP();

        }

    }

    //Specific commands for start state
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

    //checks active = temp
    private static boolean check(String[] a) {
        for (String temp : a) {
            if (active.equals(temp))
                return true;
        }
        return false;
    }

    //calls attack function in Attack class
    private static void attack() {
        for (int i = 0; i < attacks.length; i++) {
            if (active.equals(attacks[i])) {
                Attack.attack(i);
            }
        }
    }

    //Function to show commands for current map/battle.
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
                t += "\n\nslash - Attack for 70% damage and 100% hit rate";
                t += "\nstab - Attack for 100% damage and 70% hit rate";
                t += "\ncrush - Attack for 120% damage and 50% hit rate";
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
