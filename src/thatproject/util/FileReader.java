package thatproject.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public abstract class FileReader {

    public String path;
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

    public static String[] split(String input) {
        return input.split(",\\s*");
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
        
    }
}
