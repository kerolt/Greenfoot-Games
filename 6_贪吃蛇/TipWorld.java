import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tipworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TipWorld extends World
{

    /**
     * Constructor for objects of class Tipworld.
     * 
     */
    public TipWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 800, 1);
        addObject(new BackButton(),90,50);
    }
}
