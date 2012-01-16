package thatproject.readers;

import java.lang.reflect.InvocationTargetException;

import thatproject.manager.MonsterManager;
import thatproject.menu.Game;
import thatproject.util.FileReader;

public class AttackReader extends FileReader {

    private static final String pathN = "data/player/attacks.txt";

    public AttackReader() {
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
        Game.mapr = new MapReader();
    }

    private void parse() {
        int x, y;
        int[] stats = null, zone = null;
        String name, description;
        String[] encounterLines = null;
        for (int i = 0, count = 0; i < content.size() / 5; i += 5, count++) {
            x = Integer.parseInt(split(content.get(i))[0]);
            y = Integer.parseInt(split(content.get(i))[1]);
            name = content.get(i + 2);
            description = content.get(i + 3);
            insertAttack(content.get(i + 4));
            MonsterManager.populateMonsters(stats, name, description, encounterLines, zone);
        }
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