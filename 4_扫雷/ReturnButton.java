import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReturnButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReturnButton extends Button {
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MenuWorld());
        }
    }
}
