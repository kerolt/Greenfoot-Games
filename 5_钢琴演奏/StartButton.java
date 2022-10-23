import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ¿ªÊ¼°´Å¥
 */
public class StartButton extends Button
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new SelectWorld());
        }
    }
}
