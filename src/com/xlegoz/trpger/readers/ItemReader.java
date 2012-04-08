package com.xlegoz.trpger.readers;

import com.xlegoz.trpger.Game;
import com.xlegoz.trpger.TRPGer;
import com.xlegoz.trpger.util.FileReader;
import com.xlegoz.trpger.world.Inventory;

public class ItemReader extends FileReader {

    //declaring and initializing variables
    private static final String PATH = "data/items/items";
    private static final String EXT = ".txt";
    private static final int LINESIZE = 7;
    private static int counter = 0;

    //function to read the items, and call the function to add them to inventory
    public ItemReader() {
        path = PATH + EXT;
        read();
        parse();
        TRPGer.itemsLoaded = true;
    }

    //creates new thread to run multiple things at once
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

    //gets info for item and then adds to inventory
    private void parse() {
        for (int i = 0; i < content.size(); i += LINESIZE) {
            //initializing variables
            count(true);
            String name = content.get(i + count());
            String description = content.get(i + count());
            String imgPath = content.get(i + count());
            int itemType = Integer.parseInt(content.get(i + count()));
            int stat = Integer.parseInt(content.get(i + count()));
            //Adds item based on type.
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

    //function to call count() with false
    private int count() {
        return count(false);
    }

    //function to change counter value
    private int count(boolean mode) {
        if (!mode) {
            counter++;
        } else {
            counter = 0;
        }
        return counter - 1;
    }
}
