package thatproject.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import thatproject.ThatProject;

public class MainMenu extends JPanel {

    private static JTextField textField;
    private static JTextArea textArea;

    private static JDesktopPane desk = new JDesktopPane();

    public MainMenu(JFrame frame) {
        super(new GridBagLayout());
        
        //Setup text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 10, 400, 500);
        
        //Setup content pane
        desk.setOpaque(false);
        desk.add(textArea);
    }

    /**
     * Create the JFrame and add GUI contents
     */
    private static void init() {
        JFrame frame = new JFrame(ThatProject.name);//Create new JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//End Java application on window close

        MainMenu main = new MainMenu(frame);//Initialize un-static functions
        frame.setSize(ThatProject.x, ThatProject.y);//Set frame size
        frame.setVisible(true);

        //Center the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        frame.setLocation(x, y);
        
        //Add content
        frame.setContentPane(desk);
    }

    /**
     * Start thread for creatingGUI
     */
    public static void exec() {
        // Create a seperate scheduled dispatch thread for initializing GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }
}
