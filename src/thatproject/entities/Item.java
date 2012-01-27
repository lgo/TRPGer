package thatproject.entities;

public class Item {

    //declaring and initializing variables.
    public String name;
    public String description;
    public int stat;
    public String imagePath;
    private static final String nl = "<br />";
    private static final String PATH = "data/assets/";
    private static final String EXT = ".png";

    public int catagory;
    public int type;

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
        type = 0;
    }

    //gets stats and info for items in the inventory
    public String getToolTip() {
        if (type == 0)
            return "<html><b>" + name + "</b>" + nl + description + "</html>";
        else
            return "<html><b>" + name + "</b>" + nl + description + nl + itemStats() + "</html>";
    }

    /**
     * Get the image path appointed to this item
     * 
     * @return string of image path
     */
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

    //Fetches item's stats and returns it to getToolTip()
    public String itemStats() {
        if (type == 2)
            return catagory == 5 ? "Attack: " : "Armour: " + stat; //If equipment returns attack/armor of the item
        else
            return "Heal: " + stat; //if healing item returns how much it heals
    }

}
