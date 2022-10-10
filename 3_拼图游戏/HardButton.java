import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HardButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardButton extends Button {
    
    private String imageName;
    
    public HardButton(String imageName) {
        this.imageName = imageName;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            SelectImgWorld.difficulty = "hard";
            Greenfoot.setWorld(new HardGameWorld(this.imageName));
            Time.startTime = System.currentTimeMillis();
        }
    }
}
