import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectButton extends Button {
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            GameWorld.diff = 3;  // 自定义难度
            Greenfoot.setWorld(new CustomWorld());
        }
    }
}
