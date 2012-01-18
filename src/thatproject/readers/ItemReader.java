package thatproject.readers;

import thatproject.util.FileReader;

public class ItemReader extends FileReader {

    public static void exec() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                init();
            }

        }).start();
    }

    public static void init() {

    }

}
