import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is not necessary for the scrolling system.
 * It's just to visualise the scrolling movement.
 */
public class Wall extends Actor {
    
    public Wall(int type) {
        int random = 1 + Greenfoot.getRandomNumber(2);
        if (type == 0) { // level1
            setImage("map/green" + random + ".png");
        } else { // level2
            setImage("map/blue" + random + ".png");
        }
        
    }
}