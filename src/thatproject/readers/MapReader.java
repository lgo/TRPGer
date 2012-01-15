package thatproject.readers;

import thatproject.ThatProject;
import thatproject.util.FileReader;

public class MapReader extends FileReader {

    public static String path = "data/map.txt";

    public MapReader() {
        read();
        parse();
    }

    private void parse() {
        int x, y;
        String name, description;
        boolean[] directions = new boolean[4];
        for (int i = 0; i < content.length; i += 5) {
            x = Integer.parseInt(content[i]);
            y = Integer.parseInt(content[i+1]);
            name = content[i+2];
            description = content[i+3];
            
            ThatProject.mm.populateWorlds(x, y, name, description, directions);
        }
    }
}
