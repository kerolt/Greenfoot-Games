import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ·µ»Ø°´Å¥
 */
public class BackButton extends Button
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            World w = getWorld();
            if (w instanceof PianoWorld) {
                Greenfoot.setWorld(new SelectWorld());
            } else {
                Greenfoot.setWorld(new StartWorld());   
            }
        }
    }
}
