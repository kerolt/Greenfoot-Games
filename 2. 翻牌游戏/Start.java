import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends UI
{
    /**
     * Act - do whatever the StartUI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new DifficultyMenuWorld());
        }
    }
}
