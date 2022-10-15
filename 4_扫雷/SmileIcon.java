import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmileIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmileIcon extends Icon {
    
    public SmileIcon() {
        setImage("smile.png");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new GameWorld(Diff.row, Diff.col, Diff.bombNum));
        }
    }
}
