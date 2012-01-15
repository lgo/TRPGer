package thatproject.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {

    public static String path;
    protected String[] content;

    
    public void read() {
        try {
            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null) {
                content[i] = strLine;
                i++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String[] split(String input) {
        return input.split(",\\s*");
    }

}
