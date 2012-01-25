package thatproject.world;

import java.util.ArrayList;

import thatproject.Game;
import thatproject.entities.Item;
import thatproject.menu.MainMenu;

public class Inventory {

    public static Item[][] items = new Item[5][7];
    public static ArrayList<Item> itemList = new ArrayList<Item>();
    public static int itemCount;

    public static void insertItem(int x, int y, Item i) {
        itemCount++;
        MainMenu.setButton(x, y, i);
        items[x][y] = i;
    }

    public static void getItem(Item item) {
        int y = 0;
        int x = itemCount;
        while (x > 4) {
            y++;
            x -= 5;
        }
        insertItem(x, y, item);

    }

    public static void removeItem(int x, int y) {
        MainMenu.buttons[x][y].setIcon(null);
        MainMenu.buttons[x][y].setToolTipText(null);
        items[x][y] = null;

    }

    public static void useItem(int x, int y) {
        if (items[x][y].type == 1) {
            MainMenu.addTemp("\n\nYou have drank the " + items[x][y].name + " and regained " + items[x][y].stat + " health.");
            Game.p.heal(items[x][y].stat);
            removeItem(x, y);
        }
    }

    public static void addEquip(String name, String description, String imgPath, int stat, int equipType) {
        itemList.add(new Item(name, description, imgPath, stat, equipType));
    }

    public static void addUseable(String name, String description, String imgPath, int stat) {
        itemList.add(new Item(name, description, imgPath, stat));
    }

    public static void addItem(String name, String description, String imgPath) {
        itemList.add(new Item(name, description, imgPath));
    }

    public static boolean exists(int x, int y) {
        return items[x][y] != null;
    }
}
