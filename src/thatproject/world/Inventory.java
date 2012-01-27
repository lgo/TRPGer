package thatproject.world;

import java.util.ArrayList;

import thatproject.Game;
import thatproject.entities.Item;
import thatproject.menu.MainMenu;

public class Inventory {

    public static Item[][] items = new Item[5][7];
    public static ArrayList<Item> itemList = new ArrayList<Item>();
    public static int itemCount;
    public static int nextX = 0;
    public static int nextY = 0;

    //Instert given item into given button
    public static void insertItem(int x, int y, Item i) {
        itemCount++;
        MainMenu.setButton(x, y, i);
        items[x][y] = i;
    }

    //Callen when a item is gotten
    public static void getItem(Item item) {
        int y = nextY;
        int x = nextX;
        insertItem(x, y, item);
        nextSlot();
    }

    //Remove item from given slot
    public static void removeItem(int x, int y) {
        MainMenu.buttons[x][y].setIcon(null);
        MainMenu.buttons[x][y].setToolTipText(null);
        items[x][y] = null;
        nextSlot();
    }

    //Remove item from given item
    public static void removeItem(Item i) {
        for (int z = 6; z > -1; z--) {
            for (int x = 4; x > -1; x--) {
                if (items[x][z] == i) {
                    MainMenu.buttons[x][z].setIcon(null);
                    MainMenu.buttons[x][z].setToolTipText(null);
                    items[x][z] = null;
                }
            }
        }
        nextSlot();
    }

    //Retrieve next empty slot
    private static void nextSlot() {
        for (int z = 6; z > -1; z--) {
            for (int i = 4; i > -1; i--) {
                if (items[i][z] == null) {
                    nextX = i;
                    nextY = z;
                }
            }
        }
    }

    //Check if item is in inventory
    public static boolean haveItem(Item item) {
        for (int z = 6; z > -1; z--) {
            for (int i = 4; i > -1; i--) {
                if (items[i][z] != null) {
                    if (items[i][z].equals(item))
                        return true;
                }
            }
        }
        return false;
    }

    //Use potion (Remove)
    public static void useItem(int x, int y) {
        if (items[x][y].type == 1) {
            MainMenu.addTemp("\n\nYou have drank the " + items[x][y].name + " and regained " + items[x][y].stat + " health.");
            Game.p.heal(items[x][y].stat);
            removeItem(x, y);
        }
    }

    ///
    ///CONSTRUCTOR CALLS
    ///
    public static void addEquip(String name, String description, String imgPath, int stat, int equipType) {
        itemList.add(new Item(name, description, imgPath, stat, equipType));
    }

    public static void addUseable(String name, String description, String imgPath, int stat) {
        itemList.add(new Item(name, description, imgPath, stat));
    }

    public static void addItem(String name, String description, String imgPath) {
        itemList.add(new Item(name, description, imgPath));
    }

    //Check if slot is filled
    public static boolean exists(int x, int y) {
        return items[x][y] != null;
    }
}
