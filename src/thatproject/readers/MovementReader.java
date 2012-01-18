package thatproject.readers;

import thatproject.actions.Movement;
import thatproject.menu.Game;
import thatproject.util.FileReader;

public class MovementReader extends FileReader {

    private static final String pathN = "data/content/movement.txt";

    public MovementReader() {
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
        Game.mover = new MovementReader();
    }

    private void parse() {
        for (int i = 0; i < content.size() / 5; i++) {
            Movement.movements[i] = content.get(i);
        }
    }
}
