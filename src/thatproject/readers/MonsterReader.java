package thatproject.readers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import thatproject.manager.MapManager;
import thatproject.manager.MonsterManager;
import thatproject.menu.Game;
import thatproject.util.FileReader;

public class MonsterReader extends FileReader {

    private String pathN = "data/monster/monstertxt";

    public MonsterReader() {
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
        Game.monsterr = new MonsterReader();
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
            insertMonsters(content.get(i + 4), count);
            MonsterManager.populateMonsters(stats, name, description, encounterLines, zone);
        }
    }

    /**
     * Insert monster into appropriate maps
     * 
     * @param input of the map string
     * @param id of the monster
     */
    private static void insertMonsters(String input, int id) {

        Pattern p = Pattern.compile("\\((.*?)\\)");
        Matcher m = p.matcher(input);

        ArrayList<String> s = new ArrayList<String>();

        while (m.find()) {
            s.add(m.group(1));
        }

        for (int i = 0; i < s.size(); i++) {
            String[] temp = split(s.get(i), ",");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            MapManager.insertMonster(x, y, id);
        }
    }
}
