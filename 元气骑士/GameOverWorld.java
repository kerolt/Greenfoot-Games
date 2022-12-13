import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World {
    
    public GameOverWorld() {    
        super(1200, 700, 1); 
        setBackground("other/bg-black.jpg");
        showText("你已死亡！！！", getWidth() / 2, getHeight() / 2); 
    }
}
