package thatproject.readers;

import thatproject.manager.MonsterManager;
import thatproject.menu.Game;
import thatproject.util.Commands;
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
        int x, y;
        int[] stats = null, zone = null;
        String name, description;
        String[] encounterLines = null;
        Commands.attackSize(content.size() - 1);
        for (int i = 0; i < content.size() / 5; i += 5) {
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
