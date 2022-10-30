import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagentFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagentFood extends Food {
    
    public void act() {
        if (isTouching(Head.class)) {
            Greenfoot.playSound("magent.mp3");
            getWorld().removeObject(this);
            GameWorld.magentState = true;
        }
    }
}
