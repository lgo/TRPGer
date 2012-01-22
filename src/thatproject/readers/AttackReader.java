package thatproject.readers;

import thatproject.Game;
import thatproject.util.FileReader;

public class AttackReader extends FileReader {

    private static final String pathN = "data/player/attacks.txt";

    public AttackReader() {
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
        Game.attackr = new AttackReader();
    }

    private void parse() {

    }

    /**
     * Insert attack into command list
     * 
     * @param input of the map string
     * @param id of the monster
     */
    private static void insertAttack(String input) {

    }
}
