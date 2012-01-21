package thatproject.readers;

import thatproject.manager.ZoneManager;
import thatproject.menu.Game;
import thatproject.util.FileReader;

public class ZoneReader extends FileReader {

    private String pathN = "data/monster/monster.txt";

    public ZoneReader() {
        path = pathN;
        read();
        parse();
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
        int x, y, zone;
        String name, description;
        boolean[] directions = new boolean[4];
        for (int i = 0; i < content.size() / 5; i += 5) {
            x = Integer.parseInt(split(content.get(i))[0]);
            y = Integer.parseInt(split(content.get(i))[1]);
            zone = Integer.parseInt(content.get(i + 1));
            name = content.get(i + 2);
            description = content.get(i + 3);
            ZoneManager.populateZones(x, y, name, description, directions, zone);
        }
    }

}
