package thatproject.readers;

import thatproject.Game;
import thatproject.ThatProject;
import thatproject.util.FileReader;
import thatproject.world.Inventory;
import thatproject.world.World;
import thatproject.world.Zone;

public class ItemReader extends FileReader {

    private static final String PATH = "data/items/items";
    private static final String EXT = ".txt";
    private static final int LINESIZE = 6;
    private static int counter = 0;

    public ItemReader() {
        path = PATH + EXT;
        read();
        parse();
        ThatProject.threadFreeze = false;
    }

    public static void exec() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                init();
            }

        }).start();
    }

    public static void init() {
        Game.itemr = new ItemReader();
    }

    private void parse() {
        World.zones = new Zone[content.size() + 1 / LINESIZE];
        for (int i = 0, count = 0; i < content.size(); i += LINESIZE, count++) {
            count(true);
            String name = content.get(i + count());
            String description = content.get(i + count());
            String imgPath = content.get(i + count());
            int itemType = Integer.parseInt(content.get(i + count()));
            int stat = Integer.parseInt(content.get(i + count()));
            switch (itemType) {
                case 0:
                    Inventory.addItem(name, description, imgPath);
                    break;
                case 1:
                    Inventory.addUseable(name, description, imgPath, stat);
                    break;
                case 2:
                    int equipType = Integer.parseInt(content.get(i + count()));
                    Inventory.addEquip(name, description, imgPath, stat, equipType);
                    break;
            }
        }
    }

    private int count() {
        return count(false);
    }

    private int count(boolean mode) {
        if (!mode) {
            counter++;
        } else {
            counter = 0;
        }
        return counter - 1;
    }
}
