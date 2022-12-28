import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 地板
 */
public class Floor extends Actor {
    
    public Floor(int type) {
        int random = Greenfoot.getRandomNumber(3);
        if (type == 0) { // level1
            setImage("map/green-floor-" + random + ".png");
        } else { // level2
            setImage("map/blue-floor-" + random + ".png");
        }
    }
}
