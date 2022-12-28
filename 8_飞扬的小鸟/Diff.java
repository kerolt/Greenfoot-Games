import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diff extends Actor {
    
    public static int diff;
    
    public Diff() {
        this.diff = 0;
    }
    
    public void act() {
        String different = this.diff == 0 ? "easy" : "hard";
        GreenfootImage img = new GreenfootImage(different + ".png");
        setImage(img);
    }
}
