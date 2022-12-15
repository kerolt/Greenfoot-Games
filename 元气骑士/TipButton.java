import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TipButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TipButton extends UI {
    
    public TipButton() {
        setImage("other/tip-btn.png");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            World world = getWorld();
            world.addObject(new TipPanel(), world.getWidth() / 2, world.getHeight() / 2);
            world.addObject(new CloseButton(), world.getWidth() / 2 + 240, world.getHeight() / 2 - 247);
            world.removeObject(this);
        }
    }
}
