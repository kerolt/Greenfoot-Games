import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class RolePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RolePanel extends FixedObject {
    
    private GreenfootImage HPImage;
    private GreenfootImage MPImage;
    private GreenfootImage armorImage;
    
    public RolePanel() {
        setImage("role/role-panel.png");
    }
    
    public void act() {
        World world = getWorld();
        this.HPImage = new GreenfootImage(100, 59);
        this.HPImage.setColor(Color.RED);
        this.HPImage.fillRect(0, 0, Role.HP ,5);
        
        List<Strip> stripList = world.getObjects(Strip.class);
        if (stripList.size() != 0) {
            world.removeObjects(stripList);
        }
        world.addObject(new Strip("HP"), 67, 15);
        world.addObject(new Strip("armor"), 67, 28);
        world.addObject(new Strip("MP"), 67, 41);
        
        setLocation(48, 24);
    }
}
