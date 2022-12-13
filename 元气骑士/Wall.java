import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is not necessary for the scrolling system.
 * It's just to visualise the scrolling movement.
 */
public class Wall extends Actor {
    
    public Wall() {
        int random = 1 + Greenfoot.getRandomNumber(2);
        setImage("map/green" + random + ".png");
    }
}