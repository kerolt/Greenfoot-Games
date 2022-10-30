import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor {
    
    public GameOver() {
        setRotation(90);
    }
    
    public void act() {
        GameWorld world = (GameWorld)getWorld();
        if (getY() != world.getHeight() / 2) {
            move(5);
        } else {
            return;
        }
    }
}
