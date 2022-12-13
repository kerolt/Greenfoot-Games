import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        setBackground("other/start.png");
        addObject(new Actor() {
            {
                setImage("other/start-btn.png");
            }
            public void act() {
                if (Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new Level1());
                }
            }
        }, getWidth() / 2, 590);
        showText("角色移动：W、S、A、D\n攻击：J\n切换地上的武器：L\n通过传送门：空格\n\n请注意，你要将怪物全部击杀才可以通过传送门！", 300, 400);
        Greenfoot.start();
    }
}
