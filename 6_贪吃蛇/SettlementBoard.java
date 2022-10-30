import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettlementBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettlementBoard extends Board {
    
    private String pattern;
    private Integer player;
    private GreenfootImage text = null;
    
    public SettlementBoard(String pattern, Integer player) {
        this.pattern = pattern;
        this.player = player;
        init();
    }
    
    public void act() {
        GameWorld world = (GameWorld)getWorld();
        if (getY() >= world.getHeight() / 2 + 110) {
            setLocation(getX(), getY() - 5);
        } else {
            return;
        }
    }
    
    public void init() {
        if (this.pattern == "single") {
            if (this.player == 0) {
                setImage("single-loss.png");
            } else {
                setImage("single-win.png");
            } 
        } else {
            int idx = this.player == 0 ? 2 : 1;
            setImage("double-" + idx + ".png");
        }
    }
}
