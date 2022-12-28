import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor {
    
    public static void playMusic(String musicName, int musicLevel) {
        GreenfootSound shootSound = new GreenfootSound(musicName);
        shootSound.setVolume(musicLevel);
        shootSound.play();
    }
}
