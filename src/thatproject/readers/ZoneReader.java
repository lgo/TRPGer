package thatproject.readers;

import thatproject.Game;
import thatproject.ThatProject;
import thatproject.util.FileReader;
import thatproject.world.World;
import thatproject.world.Zone;

public class ZoneReader extends FileReader {

    //declaring/initializing variables
    private static final String PATH = "data/map/mapzone";
    private static final String EXT = ".txt";
    private static final int LINESIZE = 5;
    private static int counter = 0;

    //reading and parsing zone info
    public ZoneReader() {
        path = PATH + EXT;
        read();
        parse();
        ThatProject.threadFreeze = false;
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
        Game.zoner = new ZoneReader();
    }

    //gets info and creates zone
    private void parse() {
        World.zones = new Zone[content.size() + 1 / LINESIZE];
        for (int i = 0, count = 0; i < content.size(); i += LINESIZE, count++) {
            count(true);
            String name = content.get(i + count());
            String[] description = split(content.get(i + count()));
            int[] monsters = splitInt(content.get(i + count()));
            int rate = Integer.parseInt(content.get(i + count()));
            World.zones[count] = new Zone(count, name, description, monsters, rate);
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
