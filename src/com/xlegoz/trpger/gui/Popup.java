package com.xlegoz.trpger.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Popup extends JFrame {

    private static final int x = 200;
    private static final int y = 100;

    public Popup(String title, String body) {
        super(title);
        setResizable(false);
        setVisible(true);

        this.resize(x, y);
        // Center the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int tX = (dim.width - w) / 2;
        int tY = (dim.height - h) / 2;
        this.setLocation(tX, tY);
        this.requestFocus();
        
        JTextArea field = new JTextArea();
        field.setText(body);
        field.setLineWrap(true);
    }

}
