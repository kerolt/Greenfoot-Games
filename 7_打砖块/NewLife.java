import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewLife  extends Props
{

    public void act() 
    {
        super.move();
        checkStuff();
    }    
    /**
     * ºÏ≤È ¬ŒÔ£®µ≤∞Â£©
     */
    public void checkStuff()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) 
        {
            ((Board) getWorld()).increaseLives();
            getWorld().removeObject(this);
        }
        else if(getY() == getWorld().getHeight()-1) 
        {
            getWorld().removeObject(this);
        }
                    
    }
}
