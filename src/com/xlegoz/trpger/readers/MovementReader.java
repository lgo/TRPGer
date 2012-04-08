package com.xlegoz.trpger.readers;


import com.xlegoz.trpger.Game;
import com.xlegoz.trpger.actions.Movement;
import com.xlegoz.trpger.util.FileReader;

public class MovementReader extends FileReader {

    //declaring/initializing variable
    private static final String PATH = "data/content/movement.txt";

    //reading and parsing movement info
    public MovementReader() {
        path = PATH;
        read();
        parse();
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

    public static void init() {
        Game.mover = new MovementReader();
    }

    //gets movement info
    private void parse() {
        Movement.movements = new String[content.size()];
        for (int i = 0; i < content.size(); i++) {
            Movement.movements[i] = content.get(i);
        }
    }
}
