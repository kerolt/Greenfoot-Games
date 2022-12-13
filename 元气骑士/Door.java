import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor {
    
    private int time;
    
    public Door() {
        setImage("map/door-off.png");
    }
    
    public void act() {
        /*if (this.time == 20) {
            setImage("map/door-off.png");
        } else if (this.time == 40) {
            setImage("map/door-on.png");
            this.time = 0;
        }
        this.time++;*/
    }
}
