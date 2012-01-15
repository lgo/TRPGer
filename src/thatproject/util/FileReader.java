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
            FileInputStream fstream = new FileInputStream(this.path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null) {
                content.add(strLine);
                i++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] split(String input) {
        return input.split(",\\s*");
    }
}
