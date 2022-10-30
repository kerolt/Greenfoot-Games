import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BallFood extends Food {

    public void act() {
        //if (getWorld().getObjects(Head.class).get(0).getX() == getX()
        //        && getWorld().getObjects(Head.class).get(0).getY() == getY()) {
        /*if (isTouching(Head.class)) {
            Counter.score++;
            getWorld().addObject(new LimitFood(), 1 + Greenfoot.getRandomNumber(700), 1 + Greenfoot.getRandomNumber(700));
            getWorld().removeObject(this);
        }*/
        if (isTouching(Head.class)) {
            getWorld().removeObject(this);
            GameWorld.ballState = true;
        }
    }
}
