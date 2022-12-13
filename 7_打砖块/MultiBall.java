import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MultiBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiBall  extends Props
{
    /**
     * Act - do whatever the MultiBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
            Ball myBall = new Ball(); 
            getWorld().addObject( myBall, this.getX(), this.getY());
            myBall.release();
            getWorld().removeObject(this);
        }
        else if(getY() == getWorld().getHeight()-1) 
        {
            getWorld().removeObject(this);
        }
                    
    }
}
