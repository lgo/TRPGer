package thatproject.menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainMenu extends JFrame implements Runnable {

    public MainMenu(int x, int y) {
        setSize(x, y);
    }

    @Override
    public void run() {

    }

    public void start() {
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        setLocation(x, y);
    }

    public void stop() {
        //
    }

}
