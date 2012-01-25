package thatproject.entities;

import thatproject.Game;
import thatproject.menu.MainMenu;

public class Item {

    public String name;
    public String description;
    public int stat;
    public String imagePath;
    private static final String nl = "<br />";
    private static final String PATH = "data/assets/";
    private static final String EXT = ".png";

    public int catagory;
    private int type;

    /**
     * Usable constructor
     * 
     * @param n
     * @param d
     * @param i
     * @param s
     */
    public Item(String n, String d, String i, int s) {
        stat = s;
        name = n;
        description = d;
        imagePath = i;
        type = 1;
    }

    public void use() {
        Game.p.hp += stat;
        MainMenu.refreshHP();
    }

    /**
     * Item constructor
     * 
     * @param n
     * @param d
     * @param i
     */
    public Item(String n, String d, String i) {
        name = n;
        description = d;
        imagePath = i;
    }

    public String getToolTip() {
        if (type == 0)
            return "<html><b>" + name + "</b>" + nl + description + "</html>";
        else
            return "<html><b>" + name + "</b>" + nl + description + itemStats() + "</html>";
    }

    public String getPath() {
        return PATH + imagePath + EXT;
    }

    /**
     * Equipment constructor
     * 
     * @param n
     * @param d
     * @param i
     * @param s
     * @param c
     */
    public Item(String n, String d, String i, int s, int c) {
        stat = s;
        name = n;
        description = d;
        imagePath = i;
        catagory = c;
        type = 2;
    }

    public String itemStats() {
        if (type == 2)
            return catagory == 5 ? "Attack: " : "Armour: " + stat;
        else
            return "Heal: " + stat;
    }

}
