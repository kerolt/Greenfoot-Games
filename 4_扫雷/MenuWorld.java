import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Diff("easy"), getWidth() / 2 - 185, getHeight() / 2);
        addObject(new Diff("medium"), getWidth() / 2, getHeight() / 2);
        addObject(new Diff("hard"), getWidth() / 2 + 185, getHeight() / 2);
        addObject(new SelectButton(), getWidth() / 2, getHeight() / 2 + 140);
        Greenfoot.start();
    }
}
