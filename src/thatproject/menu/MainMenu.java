package thatproject.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

import thatproject.Game;
import thatproject.ThatProject;
import thatproject.entities.Item;
import thatproject.util.Commands;
import thatproject.util.Event;

public class MainMenu extends JPanel implements ActionListener {

    //Declaring and initializing variables
    private static JTextArea textArea;
    private static final int taX = 5;
    private static final int taY = 5;
    private static final int taW = 600;
    private static final int taH = 520;

    private static String contents = "";
    private static JTextField textField;
    private static final int tfX = taX;
    private static final int tfY = taY + taH + 5;
    private static final int tfW = taW;
    private static final int tfH = 20;

    public static JButton[][] buttons;
    private static final int buttonAmountWidth = 5;
    private static final int buttonAmountHeight = 7;
    private static final int buttonXStart = taX + taW + 35;
    private static final int buttonYStart = 220;
    private static final int buttonXIncrement = 5;
    private static final int buttonYIncrement = buttonXIncrement;
    private static final int buttonWidth = 40;
    private static final int buttonHeight = buttonWidth;

    public static JProgressBar healthBar;
    private static final int barX = taX + taW + 45;
    private static final int barY = 40;
    private static final int barH = 20;
    private static final int barW = 200;

    public static JTextField playerHP;
    private static final int hpX = barX + 5;
    private static final int hpY = barY - 20;
    private static final int hpW = 150;
    private static final int hpH = 20;

    public static JProgressBar staminaBar;
    private static final int sbarX = barX;
    private static final int sbarY = 80;
    private static final int sbarH = 20;
    private static final int sbarW = 200;

    public static JTextField playerStamina;
    private static final int stX = sbarX + 5;
    private static final int stY = sbarY - 20;
    private static final int stW = 150;
    private static final int stH = 20;

    private static JTextField authorField;
    private static final int atX = 650;
    private static final int atY = 527;
    private static final int atW = 200;
    private static final int atH = 30;

    public static String hi;

    private static JDesktopPane desk = new JDesktopPane();
    private static JDesktopPane introOutro = new JDesktopPane();

    private static JButton introButton;
    private static JButton[] end = new JButton[2];
    private static JFrame frame;

    public MainMenu() {

    }

    public MainMenu(JFrame f) {

        super(new GridBagLayout());
        //Setup windows look
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Initialize
        frame = f;

        String[] temp = { "data/assets/gameover.png", "data/assets/win.png" };
        //Create two end buttons, one for loss one for win
        for (int i = 0; i < 2; i++) {
            end[i] = new JButton();
            end[i] = new JButton();
            end[i].setBorder(null);
            end[i].setBounds(0, 0, 504, 360);
            end[i].setIcon(new ImageIcon(temp[i]));
            final int z = i;
            //Exit on button press
            end[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    System.exit(0);
                }

            });

        }
        //Starting frame size
        f.setSize(504, 360);// Set frame size
        f.setVisible(true);

        // Center the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = f.getSize().width;
        int h = f.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        f.setLocation(x, y);
        //Intro image button and settings
        introButton = new JButton();
        introButton.setBorder(null);
        introButton.setBounds(0, 0, 504, 360);
        introButton.setIcon(new ImageIcon("data/assets/intro.png"));
        introButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //Tranistion from intro into game panes
                frame.remove(introOutro);
                frame.setContentPane(desk);
                reSize(ThatProject.x, ThatProject.y);
                //Gain focus on textfield
                focus();
            }

        });
        //Add pane stuff
        introOutro.add(introButton);
        frame.setContentPane(introOutro);

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

                final int tempI = i, tempJ = j;
                buttons[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        //Call button function with appropriate button ID
                        Event.buttonPress(tempI, tempJ);
                        //Regain focus
                        MainMenu.focus();
                    }

                });
            }
        }
        //Add each button
        for (JButton[] button : buttons) {
            for (JButton button2 : button) {
                desk.add(button2);
            }
        }

        //calls functions to create health and stamina bar
        healthBar();
        staminaBar();

        //Create made by text field
        authorField = new JTextField() {
            @Override
            public void setBorder(Border border) {
            }
        };
        authorField.setBounds(atX, atY, atW, atH);
        authorField.setText("Created by Joey, Sean and Jackson!");
        authorField.setOpaque(false);
        desk.add(authorField);

        // Setup content pane
        desk.setOpaque(false);

        //LOADED MENU
        ThatProject.menuLoaded = true;
    }

    //Resize to x and y size
    protected static void reSize(int x, int y) {
        //Deprecated but useable resize
        frame.resize(x, y);
        // Center the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        x = (dim.width - w) / 2;
        y = (dim.height - h) / 2;
        frame.setLocation(x, y);
    }

    @Override
    //Action listener for text field entry (Enter button)
    public void actionPerformed(ActionEvent evt) {
        Commands.command(textField.getText());
        textField.setText("");
    }

    /**
     * Adds text to the textarea
     * 
     * @param s to add to textarea
     */
    public static void add(String s) {
        contents += s;
        set(contents, true);
    }

    //Add a temperary string (Don't append to new add's and remove on addTemp's)
    public static void addTemp(String s) {
        set(contents + s, true);
    }

    /**
     * Sets text to the textarea (Used to call from add())
     * 
     * @param s to set to textarea
     */
    public static void set(String s, boolean overmode) {
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

    //Sets the textarea to said string
    public static void set(String s) {
        contents = s;
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

    //Threaded function
    public static void set() {
        textArea.setText(hi);
    }

    /**
     * Create the JFrame and add GUI contents (Static call to non-static
     * conscructor)
     */
    private static void init() {
        JFrame frame = new JFrame(ThatProject.name);// Create new JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// End Java application on window close

        ThatProject.m = new MainMenu(frame);// Initialize un-static functions and create object
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Start thread for calling and creating the GUI
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

    //Focuses window
    public static void focus() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textField.requestFocus();
            }
        });
    }

    //Places health bar onto the screen
    public void healthBar() {
        UIManager.put("ProgressBar.foreground", Color.RED);
        //sets progress bar specifications for health
        healthBar = new JProgressBar();
        healthBar.setBounds(barX, barY, barW, barH);
        healthBar.setMinimum(0);
        healthBar.setMaximum(Game.p.hpMax);
        healthBar.setStringPainted(true);

        healthBar.setValue(Game.p.hp);
        desk.add(healthBar);

        //sets textfield specifications and text for detail on player health bar.
        playerHP = new JTextField() {
            @Override
            public void setBorder(Border border) {
            }
        };
        playerHP.setBounds(hpX, hpY, hpW, hpH);
        playerHP.setText("Health: " + Game.p.hp + "/" + Game.p.hpMax);
        playerHP.setOpaque(false);
        desk.add(playerHP);
    }

    public void staminaBar() {

        // Setup Stamina bar and flair
        UIManager.put("ProgressBar.foreground", Color.GREEN);
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        //sets progress bar specifications for stamina
        staminaBar = new JProgressBar();
        staminaBar.setBounds(sbarX, sbarY, sbarW, sbarH);
        staminaBar.setMinimum(0);
        staminaBar.setMaximum(Game.p.staminaMax);
        staminaBar.setStringPainted(true);

        staminaBar.setValue(Game.p.stamina);
        desk.add(staminaBar);

        //sets textfield specifications and text for detail on player stamina bar.
        playerStamina = new JTextField() {
            @Override
            public void setBorder(Border border) {
            }
        };
        playerStamina.setBounds(stX, stY, stW, stH);
        playerStamina.setText("Stamina: " + Game.p.stamina + "/" + Game.p.staminaMax);
        playerStamina.setOpaque(false);
        desk.add(playerStamina);
    }

    //displays current health
    public static void refreshHP() {

        healthBar.setValue(Game.p.hp < 0 ? 0 : Game.p.hp);
        healthBar.setMaximum(Game.p.hpMax);
        playerHP.setText("Health: " + (Game.p.hp < 0 ? 0 : Game.p.hp) + "/" + Game.p.hpMax);

    }

    //set inventory's icon and tool tip.
    public static void setButton(int x, int y, Item i) {
        buttons[x][y].setIcon(new ImageIcon(i.getPath()));
        buttons[x][y].setToolTipText(i.getToolTip());

    }

    //Called to produce the end game screen, boolean whether or not gameover or win
    public static void setGameEnd(boolean win) {
        int temp = -1;
        if (win) {
            temp = 1;
        } else {
            temp = 0;
        }
        //Transition for panes
        frame.remove(desk);
        frame.setContentPane(introOutro);
        introOutro.removeAll();
        introOutro.add(end[temp]);
        reSize(504, 360);
        desk.removeAll();
    }
}
