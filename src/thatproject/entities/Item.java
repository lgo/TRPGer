package thatproject.entities;

public class Item {

    public String name;
    public String description;
    public int stat;
    public String imagePath;

    public Item(String n, String d, String i, int s) {
        stat = s;
        name = n;
        description = d;
        imagePath = i;
    }

    public Item(String n, String d, String i) {
        name = n;
        description = d;
        imagePath = i;
    }

    public String getToolTip() {
        return null;
    }

}
