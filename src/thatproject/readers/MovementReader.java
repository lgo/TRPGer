package thatproject.readers;

import thatproject.Game;
import thatproject.actions.Movement;
import thatproject.util.FileReader;

public class MovementReader extends FileReader {

    private static final String PATH = "data/content/movement.txt";

    public MovementReader() {
        path = PATH;
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
        Game.mover = new MovementReader();
    }

    private void parse() {
        Movement.movements = new String[content.size()];
        for (int i = 0; i < content.size(); i++) {
            Movement.movements[i] = content.get(i);
        }
    }
}
