package com.xlegoz.trpger.gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MenuReader {

    
    public MenuReader() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("data/gui/menu.layout"));
        } catch (FileNotFoundException e) {
            new StandardMenu();
        }
    }
    
}
