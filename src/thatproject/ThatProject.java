/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thatproject;

import thatproject.menu.MainMenu;

/**
 *
 * @author Joey
 */
public class ThatProject {


    public static int x = 700, y = 600;
    public static MainMenu main = new MainMenu(x, y);
    
    public static void main(String[] args) {
        main.start();
    }
}
