package thatproject.util;

public class Commands {

    private static String[] attacks = { "hi" };
    
    private static String active;
    
    public static void command(String s) {
        active = s;
        
        if (check(attacks)) {
            attack();
        }
    }

    private static boolean check(String[] a) {
        for (String temp : a) {
            if (active.equals(temp)) {
                return true;
            }
        }
        return false;
    }
    
    private static void attack() {
        
    }
    
}
