import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 地板
 */
public class Floor extends Actor {
    
    public Floor() {
        int random = Greenfoot.getRandomNumber(4);
        setImage("map/green-floor-" + random + ".png");
    }
}
