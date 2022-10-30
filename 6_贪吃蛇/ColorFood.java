import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColorFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColorFood extends Food {
    
    public ColorFood(int r, int g, int b) {
        GreenfootImage img = new GreenfootImage(5, 5);
        img.setColor(new Color(r, g, b));
        img.drawOval(0, 0, 5, 5);
        //img.fillOval(0, 0, 6, 6);
        img.fill();
        setImage(img);
    }
    
    public void act() {
        if (isTouching(Head.class)) {
            GameWorld.colorFoodNumber--;
            getWorld().removeObject(this);
        }
    }
}
