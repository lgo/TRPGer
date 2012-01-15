package thatproject.readers;

import thatproject.ThatProject;
import thatproject.util.FileReader;

public class MapReader extends FileReader {

    public static String path = "data/map.txt";

    public MapReader() {
        read();
        parse();
    }
    
    public static void init() {
        ThatProject.mapr = new MapReader();
    }

    private void parse() {
        int x, y;
        String name, description;
        boolean[] directions = new boolean[4];
        for (int i = 0; i < content.length / 5; i += 5) {
            x = Integer.parseInt(content[i]);
            y = Integer.parseInt(content[i + 1]);
            name = content[i + 2];
            description = content[i + 3];
            directions = directionSplit(content[i + 4]);
            ThatProject.mm.populateWorlds(x, y, name, description, directions);
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
