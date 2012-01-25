package thatproject.entities.objects;

import thatproject.Game;
import thatproject.entities.Item;
import thatproject.menu.MainMenu;

public class Usable extends Item {
    public Usable(String n, String d, String i, int s) {
        super(n, d, i, s);
    }

    public void use() {
        Game.p.hp += stat;
        MainMenu.refreshHP();
    }
}
