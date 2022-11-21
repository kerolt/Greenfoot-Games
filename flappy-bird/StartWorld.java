import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{

    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        addObject(new Title(), getWidth() / 2, 200);
        addObject(new SelectButton("left"), getWidth() / 2 - 230, 350);
        addObject(new Diff(), getWidth() / 2, 350);
        addObject(new SelectButton("right"), getWidth() / 2 + 230, 350);
        addObject(new Parttern(0), getWidth() / 2 - 200, 470);
        addObject(new Parttern(1), getWidth() / 2 + 200, 470);
        Greenfoot.start();
    }
}
