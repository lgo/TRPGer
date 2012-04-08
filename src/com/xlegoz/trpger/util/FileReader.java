package com.xlegoz.trpger.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class FileReader {

    //declaring variable 
    public String path;
    protected ArrayList<String> content = new ArrayList<String>();

    //REad the file into an arraylist
    public void read() {
        try {
            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                content.add(strLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Regex split on commas
    public static String[] split(String input) {
        return split(input, ",");
    }

    //Custom input regex split
    public static String[] split(String input, String regex) {
        return input.split(regex);
    }

    //Regex split on commas, return integer array
    public static int[] splitInt(String input) {
        String[] s = input.split(",");
        int[] temp = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            temp[i] = Integer.parseInt(s[i]);
        }
        return temp;
    }
}
