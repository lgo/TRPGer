package thatproject.readers;

import thatproject.Game;
import thatproject.manager.MonsterManager;
import thatproject.util.FileReader;

public class MonsterReader extends FileReader {

    private static final String PATH = "data/monster/monster";
    private static final String EXT = ".txt";
    private static final int LINESIZE = 7;
    private static int counter = 0;

    public MonsterReader() {
        path = PATH + EXT;
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
        Game.monsterr = new MonsterReader();
    }

    private void parse() {
        for (int i = 0; i < content.size(); i += LINESIZE) {
            String temp;
            count(true);
            String name = content.get(i + count());
            int rate = Integer.parseInt(content.get(i + count()));
            int health = Integer.parseInt(content.get(i + count()));
            int[] stats = splitInt(content.get(i + count()));
            int[] itemDrops = (temp = content.get(i + count())) == null ? splitInt(temp) : null;
            String encounter = content.get(i + count());
            MonsterManager.populateMonsters(name, rate, health, stats, itemDrops, encounter);
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
