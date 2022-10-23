import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicBoard extends Board {
    
    public static int musicIdx;
    
    public MusicBoard() {
        MusicBoard.musicIdx = 0;
    }
    
    public void act() {
        GreenfootImage gfi = new GreenfootImage("music" + MusicBoard.musicIdx + ".png");
        setImage(gfi);
    }
}
