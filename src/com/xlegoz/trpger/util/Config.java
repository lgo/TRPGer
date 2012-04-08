package com.xlegoz.trpger.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {
    
    private BufferedReader bfr;

    public static String getScripts() {
        return (String) fetch(null);
    }

    private static Object fetch(String path) {
        return path;
    }
    
    public Config() {
        try {
       bfr = new BufferedReader(new FileReader("data/config.settings")); 
        } catch (IOException e) {
            
        }
    }
    
}
