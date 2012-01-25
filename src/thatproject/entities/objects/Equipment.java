package thatproject.entities.objects;

import thatproject.entities.Item;

public class Equipment extends Item {

    public int catagory;

    public Equipment(String n, String d, String i, int s, int c) {
        super(n, d, i, s);
        catagory = c;
    }

    @Override
    public String getToolTip() {
        System.out.println("WHOO (Equipment)");
        String prefix = catagory == 5 ? "Attack: " : "Armour: ";
        return super.getToolTip(prefix + stat);
    }
}
