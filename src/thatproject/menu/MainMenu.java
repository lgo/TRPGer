package thatproject.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import thatproject.ThatProject;
import thatproject.util.Commands;

public class MainMenu extends JPanel implements ActionListener {

    private static JTextArea textArea;
    private static final int taX = 5;
    private static final int taY = 5;
    private static final int taW = 400;
    private static final int taH = 520;

    private static String contents = "";

    private static JTextField textField;
    private static final int tfX = taX;
    private static final int tfY = taY + taH + 5;
    private static final int tfW = taW;
    private static final int tfH = 20;

    private static String hi;

    private static JDesktopPane desk = new JDesktopPane();

    public MainMenu() {

    }

    public MainMenu(JFrame frame) {
        super(new GridBagLayout());

        // Setup text area
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(taX, taY, taW, taH);

        // Setup text field
        textField = new JTextField();
        textField.setEditable(true);
        textField.setBounds(tfX, tfY, tfW, tfH);
        textField.addActionListener(this);

        // Setup content pane
        desk.setOpaque(false);
        desk.add(textArea);
        desk.add(textField);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Commands.command(textField.getText());
        textField.setText("");
    }

    /**
     * Adds text to the textarea
     * 
     * @param String to add
     */
    public void add(String s) {
        set(contents + s);
    }

    /**
     * Sets text to the textarea
     * 
     * @param String to set
     */

    public void set(String s) {
        // Create a seperate dispatch thread for initializing GUI
        hi = s;
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    set();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void set() {
        textArea.setText(hi);
        contents = hi;
    }

    /**
     * Create the JFrame and add GUI contents
     */
    private static void init() {
        JFrame frame = new JFrame(ThatProject.name);// Create new JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// End Java
                                                             // application on
                                                             // window close

        ThatProject.m = new MainMenu(frame);// Initialize un-static functions
                                            // and create object
        frame.setSize(ThatProject.x, ThatProject.y);// Set frame size
        frame.setVisible(true);

        // Center the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        frame.setLocation(x, y);

        // Add content
        frame.setContentPane(desk);
    }

    /**
     * Start thread for creating the GUI
     */
    public static void exec() {
        // Create a seperate dispatch thread for initializing GUI
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    init();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        focus();
    }

    public static void focus() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textField.requestFocus();
            }
        });
    }
}
