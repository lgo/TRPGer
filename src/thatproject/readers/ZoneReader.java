package thatproject.readers;

import thatproject.Game;
import thatproject.ThatProject;
import thatproject.util.FileReader;
import thatproject.world.World;
import thatproject.world.Zone;

public class ZoneReader extends FileReader {

    private static final String PATH = "data/map/mapzone";
    private static final String EXT = ".txt";
    private static final int LINESIZE = 5;
    private static int counter = 0;

    public ZoneReader() {
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
        Game.zoner = new ZoneReader();
    }

    private void parse() {
        World.zones = new Zone[content.size()+1 / LINESIZE];
        for (int i = 0, count = 0; i < content.size(); i += LINESIZE, count++) {
            count(true);
            String name = content.get(i + count());
            String[] description = split(content.get(i + count()));
            int[] monsters = splitInt(content.get(i + count()));
            int rate = Integer.parseInt(content.get(i + count()));
            World.zones[count] = new Zone(count, name, description, monsters, rate);
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
