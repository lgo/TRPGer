package thatproject.entities;

public class Item {

    public String name;
    public String description;
    public int stat;
    public String imagePath;
    private static final String nl = "<br />";
    private static final String PATH = "data/assets/";
    private static final String EXT = ".png";

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
        return "<html><b>" + name + "</b>" + nl + description + "</html>";
    }

    public String getToolTip(String s) {
        return "<html><b>" + name + "</b>" + nl + description + s + "</html>";
    }

    public String getPath() {
        return PATH + imagePath + EXT;
    }

}
