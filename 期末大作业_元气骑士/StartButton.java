import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends UI {
    
    public StartButton() {
        setImage("other/start-btn.png");
        
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            StartWorld.startBgm.stop();
            Greenfoot.setWorld(new Level1());
        }
    }
}
