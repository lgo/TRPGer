package thatproject.readers;

import thatproject.Game;
import thatproject.manager.MapManager;
import thatproject.util.FileReader;

public class MapReader extends FileReader {

    private static final String PATH = "data/map/map";
    private static final String EXT = ".txt";
    private static int /* DEBUG mapAmount = 8; */mapAmount = 2;
    private static final int LINESIZE = 4;
    private static int counter = 0;

    public MapReader() {
        for (int i = 1; i - 1 < mapAmount; i++) {
            path = PATH + i + EXT;
            read();
            parse(i);
        }
        Game.loaded = true;
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
        Game.mapr = new MapReader();
    }

    private void parse(int zone) {
        for (int i = 0; i < content.size() / LINESIZE; i += LINESIZE) {
            count(true);
            String[] xy = split(content.get(i + count()));
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            String name = content.get(i + count());
            String description = content.get(i + count());
            boolean[] directions = directionSplit(content.get(i + count()));
            MapManager.populateWorlds(zone - 1, x, y, name, description, directions);
        }
    }

    /**
     * Returns appropriate boolean array for input
     * 
     * @param line containing input
     * @return booleans for directions passable
     */
    private boolean[] directionSplit(String line) {
        boolean[] bools = new boolean[4];
        String[] splits = split(line);
        int[] ints = new int[4];
        for (int i = 0; i < 4; i++) {
            ints[i] = Integer.parseInt(splits[i]);
            bools[i] = ints[i] == 1 ? true : false;
        }
        return bools;
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
