package thatproject.readers;

import thatproject.Game;
import thatproject.ThatProject;
import thatproject.manager.MapManager;
import thatproject.util.FileReader;

public class MapReader extends FileReader {

    //declaring/initializing variables
    private static final String PATH = "data/map/map";
    private static final String EXT = ".txt";
    private static int /* DEBUG mapAmount = 8; */mapAmount = 1;
    private static final int LINESIZE = 5;
    private static int counter = 0;

    //function to read map
    public MapReader() {
        while (ThatProject.threadFreeze) {
            Thread.yield();
        }
        for (int i = 1; i - 1 < mapAmount; i++) {
            path = PATH + i + EXT;
            read();
            parse(i);
        }
        Game.loaded = true;
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

    //Start non-static map reader calls with constructor
    public static void init() {
        Game.mapr = new MapReader();
    }

    //gets info and then calls function to set map in game
    private void parse(int zone) {
        for (int i = 0; i < content.size(); i += LINESIZE) {
            //declaring and initializing variables
            String[] xy = split(content.get(i + 0));
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            boolean spawn = Integer.parseInt(content.get(i + 1)) == 1 ? false : true;
            String description = content.get(i + 2);
            boolean[] directions = directionSplit(content.get(i + 3));
            //calling function for map.
            MapManager.populateWorlds(zone - 1, x, y, spawn, description, directions);
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

}
