package thatproject.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

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

    private static JButton[][] buttons;
    private static final int buttonAmountWidth = 5;
    private static final int buttonAmountHeight = 7;
    private static final int buttonXStart = 440;
    private static final int buttonYStart = 220;
    private static final int buttonXIncrement = 5;
    private static final int buttonYIncrement = buttonXIncrement;
    private static final int buttonWidth = 40;
    private static final int buttonHeight = buttonWidth;

    public static JProgressBar healthBar;
    private static final int barX = 450;
    private static final int barY = 40;
    private static final int barH = 20;
    private static final int barW = 200;

    public static JTextField playerHP;
    private static final int hpX = barX + 5;
    private static final int hpY = barY - 20;
    private static final int hpW = 150;
    private static final int hpH = 20;

    private static String hi;

    private static JDesktopPane desk = new JDesktopPane();

    public MainMenu() {

    }

    public MainMenu(JFrame frame) {
        super(new GridBagLayout());
        // Initialise
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        buttons = new JButton[buttonAmountWidth][buttonAmountHeight];

        // Setup text area
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(taX, taY, taW, taH);
        desk.add(textArea);

        // Setup text field
        textField = new JTextField();
        textField.setEditable(true);
        textField.setBounds(tfX, tfY, tfW, tfH);
        textField.addActionListener(this);
        desk.add(textField);

        // Setup inventory buttons

        for (int i = 0; i < buttonAmountWidth; i++) {
            for (int j = 0; j < buttonAmountHeight; j++) {

                buttons[i][j] = new JButton();
                buttons[i][j].setBounds(buttonXStart + i * buttonXIncrement + i * buttonWidth, buttonYStart + j * buttonYIncrement + j * buttonHeight, buttonWidth, buttonHeight);
            }
        }
        for (JButton[] button : buttons) {
            for (JButton button2 : button) {
                desk.add(button2);
            }
        }

        // Setup progress bar and flair
        UIManager.put("ProgressBar.foreground", Color.RED);
        UIManager.put("ProgressBar.foreground", Color.RED);
        healthBar = new JProgressBar();
        healthBar.setBounds(barX, barY, barW, barH);
        healthBar.setMinimum(0);
        ThatProject.threadFreeze = true;
        while (!ThatProject.threadFreeze) {
        Thread.yield();
        }
        healthBar.setMaximum(Game.p.hpMax);
        healthBar.setStringPainted(true);
        
        healthBar.setValue(50);
        desk.add(healthBar);
        
        playerHP = new JTextField(){
            @Override public void setBorder(Border border) {
            }
        };
        playerHP.setBounds(hpX, hpY, hpW, hpH);
        playerHP.setText("Health: " + Game.p.hp + "/" + Game.p.hpMax);
        playerHP.setOpaque(false);
        desk.add(playerHP);

        // Setup content pane
        desk.setOpaque(false);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Commands.command(textField.getText());
        textField.setText("");
    }

    /**
     * Adds text to the textarea
     * 
     * @param s to add to textarea
     */
    public void add(String s) {
        set(contents + s);
    }

    /**
     * Sets text to the textarea
     * 
     * @param s to set to textarea
     */

    public static void set(String s) {
        // Create a seperate dispatch thread for initializing GUI
        hi = s;
        try {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    set();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void set() {
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
            SwingUtilities.invokeLater(new Runnable() {
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
