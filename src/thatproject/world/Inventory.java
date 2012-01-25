package thatproject.world;

import java.util.ArrayList;

import thatproject.entities.Item;
import thatproject.menu.MainMenu;

public class Inventory {

    public static Item[][] items = new Item[5][7];
    public static ArrayList<Item> itemList = new ArrayList<Item>();
    public static int itemCount;

    public static void insertItem(int x, int y, Item i) {
        itemCount++;
        MainMenu.setButton(x, y, i);
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

    public static void removeItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            for (int z = 0; z < items[i].length; z++) {
                if (items[i][z].equals(item)) {
                    MainMenu.buttons[i][z].setIcon(null);
                    MainMenu.buttons[i][z].setToolTipText(null);
                    return;
                }
            }
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
}
