import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 传送门
 */
public class Portal extends Actor {
    
    private GifImage gif;
    
    public Portal() {
        gif = new GifImage("other/portal.gif");
    }
    
    public void act() {
        setImage(gif.getCurrentImage());
        if (Greenfoot.isKeyDown("space") && getWorld().getObjects(Enemy.class).size() == 0 && isTouching(Role.class)) {
            Greenfoot.setWorld(new Level2());
        }
    }
}
