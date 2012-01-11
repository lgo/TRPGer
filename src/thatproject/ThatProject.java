package thatproject;

import thatproject.menu.MainMenu;

public class ThatProject {

    public static int x = 700, y = 600;
    public static MainMenu main = new MainMenu(x, y);
    
    public static Save s = new Save();

    public static void main(String[] args) {
        main.start();
        s.createSave();
    }
}
