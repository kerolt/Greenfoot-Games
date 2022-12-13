import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick  extends Actor
{
    private  GreenfootImage brick1 = new GreenfootImage("brick1.png");
    private  GreenfootImage brick2 = new GreenfootImage("brick2.png");
    private  GreenfootImage brick3 = new GreenfootImage("brick3.png");
    private int hit = 0;
    
    public Brick(int foo)
    {
        if (foo == 1)
        {
            setImage(brick1);
            hit = 1;
        }
        if (foo == 2)
        { 
            setImage(brick2);
            hit = 2;
        }
        if (foo == 3)
        {
            setImage(brick3);
            hit = 3;
        }       
    }
    
    public void effect()
    {
        if (hit == 1)
        {
            hit--;
            getWorld().removeObject(this);
        }
        if (hit==2)
        {
            hit--;
            setImage(brick1);
        }
        if (hit==3)
        {
            hit--;
            setImage(brick2);
        }
    }
    
    public boolean checkHit()
    {
        Actor a = getOneIntersectingObject(null);
        if ( a != null )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
      
    public void act() 
    {

    }    
   
}
