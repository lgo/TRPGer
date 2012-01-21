package thatproject.readers;

import thatproject.Game;
import thatproject.util.FileReader;
import thatproject.world.Zone;

public class ZoneReader extends FileReader {

    private static final String PATH = "data/map/mapzone";
    private static final String EXT = ".txt";
    private static int /* DEBUG zoneAmount = 8; */zoneAmount = 2;
    private static final int LINESIZE = 3;
    private static int counter = 0;

    public ZoneReader() {
        Game.world.zones = new Zone[zoneAmount];
        for (int i = 1; i - 1 < zoneAmount; i++) {
            path = PATH + i + EXT;
            read();
            parse(i);
        }
        MapReader.exec();
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

    private void parse(int z) {
        System.out.println(content.size());
        for (int i = 0, count = 0; i < content.size() / LINESIZE; i += LINESIZE, count++) {
            count(true);
            String name = content.get(i + count());
            String[] description = split(content.get(i + count()));
            int[] monsters = splitInt(content.get(i + count()));
            Game.world.zones[count] = new Zone(i, name, description, monsters);
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
