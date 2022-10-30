import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Board {
    
    public GameOver() {
        
    }
    
    public void act() {
        GameWorld world = (GameWorld)getWorld();
        if (getY() <= world.getHeight() / 2 - 110) {
            setLocation(getX(), getY() + 5);
        } else {
            return;
        }
    }
}
