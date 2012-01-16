package thatproject.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class FileReader {

    public String path;
    protected ArrayList<String> content = new ArrayList<String>();

    public void read() {
        try {
            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                content.add(strLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] split(String input) {
        return split(input, ",");
    }

    public static String[] split(String input, String regex) {
        return input.split(regex);
    }
}
