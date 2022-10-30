import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class single here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OnePlayer extends Card {
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new GameWorld("single"));
        }
    }
}
