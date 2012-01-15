package thatproject.world;

public class Map {
    private int x;
    private int y;
    
    private String name;
    private String description;
    
    private boolean[] direction = new boolean[4];
    
    public Map(int xLoc, int yLoc, String n, String d, boolean[] dir) {
        x = xLoc;
        y = yLoc;
        name = n;
        description = d;
        direction = dir;
    }
    
    
}
