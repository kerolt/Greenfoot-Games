import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Props  extends Actor
{
    private int deltaX;
    private int deltaY;    

    public void act() 
    {
      move();
    }
    //µÀ¾ßÒÆ¶¯
    public void move()
    {
         deltaY = 3;
         setLocation (getX() + deltaX, getY() + deltaY);
    }
}
