import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SimpleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyButton extends Button {
    
    private String imageName;
    
    public EasyButton(String imageName) {
        this.imageName = imageName;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            SelectImgWorld.difficulty = "easy";
            Greenfoot.setWorld(new EasyGameWorld(this.imageName));
            Time.startTime = System.currentTimeMillis();
        }
    }
}
