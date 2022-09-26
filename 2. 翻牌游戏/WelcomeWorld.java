import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Welcome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeWorld extends World
{

    /**
     * Constructor for objects of class Welcome.
     * 
     */
    public WelcomeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        // Greenfoot.start();
    }

    /**
     * 为程序启动准备场景
     * 即：创建初始的物体并将其加入场景。
     */
    private void prepare() {
        addObject(new Start(), getWidth() / 2, getHeight() / 2 + 80);
        addObject(new Title(), getWidth() / 2, getHeight() / 2 - 100);
        addObject(new TipsButton(), 540, 350);
    }
}
