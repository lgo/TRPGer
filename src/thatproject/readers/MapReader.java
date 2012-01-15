package thatproject.readers;

import java.lang.reflect.InvocationTargetException;

import thatproject.ThatProject;
import thatproject.util.FileReader;

public class MapReader extends FileReader {

    private String pathN = "data/map.txt";

    public MapReader() {
        path = pathN;
        read();
        parse();
    }

    /**
     * Start thread for creating the GUI
     */
    public static void exec() {
        // Create a seperate dispatch thread for initializing GUI
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    init();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        ThatProject.mapr = new MapReader();
    }

    private void parse() {
        int x, y, zone;
        String name, description;
        boolean[] directions = new boolean[4];
        for (int i = 0; i < content.size() / 5; i += 5) {
            x = Integer.parseInt(split(content.get(i))[0]);
            y = Integer.parseInt(split(content.get(i))[1]);
            zone = Integer.parseInt(content.get(i + 1));
            name = content.get(i + 2);
            description = content.get(i + 3);
            directions = directionSplit(content.get(i + 4));
            ThatProject.mm.populateWorlds(x, y, name, description, directions, zone);
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
