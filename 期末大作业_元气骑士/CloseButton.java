import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CloseButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseButton extends UI {
    
    public CloseButton() {
        setImage("other/close-btn.png");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            World world = getWorld();
            world.addObject(new TipButton(), 65, 650);
            world.removeObject(world.getObjects(TipPanel.class).get(0));
            world.removeObject(this);
        }
    }
}
