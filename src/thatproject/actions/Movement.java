package thatproject.actions;

import java.util.Random;

import thatproject.util.FileReader;
import thatproject.world.Map;

public class Movement {

    public static String[] movements;
    private static Random generator = new Random();

    /**
     * Get a movement string to use for entering a new map
     * 
     * @param to map being entered
     * @param dir the player is going
     * @return movement string to print
     */
    public static String getMovement(Map to, int dir) {
        int i = generator.nextInt(movements.length - 1);
        String[] s;
        String string = "";
        for (String move : movements) {
            System.out.println(move);
        }
        if ((s = FileReader.split(Movement.movements[i], ":")).length != 1) {
            for (int j = 1; j < s.length; j++) {
                if (j == 1) {
                    string += s[j - 1] + to.getName() + s[j];
                } else {
                    string += to.getName() + s[j];
                }
            }
        } else {
            string = s[0];
        }

        return splitDirection(splitName(movements[i], to.getName()), dir);
    }

    /**
     * Splits the string for the scripted variables
     * 
     * @param string to split
     * @param name of the map the player is entering
     * @return string with the proper map name inserted to the variable
     */
    private static String splitName(String string, String name) {
        String[] s;
        if ((s = FileReader.split(string, ":")).length != 1) {
            string = "";
            for (int j = 1; j < s.length; j++) {
                if (j == 1) {
                    string += s[j - 1] + name + s[j];
                } else {
                    string += name + s[j];
                }
            }
        }
        return string;
    }

    /**
     * Splits the string for the scripted variables
     * 
     * @param string to split
     * @param dir the player is going
     * @return string with the proper direction inserted to the variable
     */
    private static String splitDirection(String string, int dir) {
        String[] s;
        if ((s = FileReader.split(string, "]")).length != 1) {
            string = "";
            String direction = "";
            switch (dir) {
                case 0:
                    direction = "North";
                    break;
                case 1:
                    direction = "South";
                    break;
                case 2:
                    direction = "East";
                    break;
                case 3:
                    direction = "West";
                    break;
            }

            for (int j = 1; j < s.length; j++) {
                if (j == 1) {
                    string += s[j - 1] + direction + s[j];
                } else {
                    string += direction + s[j];
                }
            }
        }
        return string;
    }

}
