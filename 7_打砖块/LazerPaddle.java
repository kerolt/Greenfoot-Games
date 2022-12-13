import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LazerPaddle  extends Props
{

    public void act() 
    {
        super.move();
        checkStuff();
    }    
    /**
     *ºÏ≤È ¬ŒÔ£®µ≤∞Â£©
     */
    public void checkStuff()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) 
        {
            ((Board) getWorld()).reduceLives();
            getWorld().removeObject(this);
        }
        else if(getY() == getWorld().getHeight()-1) 
        {
            getWorld().removeObject(this);
        }              
    }
}
