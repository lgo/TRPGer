package thatproject.readers;

import java.lang.reflect.InvocationTargetException;

import thatproject.ThatProject;
import thatproject.actions.Movement;
import thatproject.util.FileReader;

public class MovementReader extends FileReader {

    private String pathN = "data/content/movement.txt";

    public MovementReader() {
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
        ThatProject.mover = new MovementReader();
    }

    private void parse() {
        for (int i = 0; i < content.size() / 5; i++) {
            Movement.movements[i] = content.get(i);
        }
    }
}
