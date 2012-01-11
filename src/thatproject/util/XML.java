package thatproject.util;

import java.io.File;

public class XML {

    private static String[] paths = {"data/save.xml"};
    
    public XML () {
        init();
    }
    
    private static void init () {
        if (fileExists(paths[0])) {
            
        } else {
            
        }
    }
    
    private static boolean fileExists(String path) {
        File f = new File(path);
        if(f.exists()) return true;
        else return false;
    }
    
    private static void save() {
        for (String path : paths) {        
            
        }
    }
    
}
