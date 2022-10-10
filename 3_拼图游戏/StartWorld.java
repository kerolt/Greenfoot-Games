import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
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
        super(600, 400, 1); 
        prepare();
    }
    /**
     * 为程序启动准备场景
     * 即：创建初始的物体并将其加入场景。
     */
    private void prepare() {
        addObject(new StartButton(), this.getWidth() / 2, this.getHeight() / 2 + 150);
        addObject(new Prompt(), 550, 40);
    }
}
