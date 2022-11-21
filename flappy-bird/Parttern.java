import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 选择单人或双人模式
 */
public class Parttern extends Actor {
    
    public int parttern;
    
    public Parttern(int parttern) {
        this.parttern = parttern;
        String fileName = parttern == 0 ? "single.png" : "double.png";
        setImage(fileName);
    }
    
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Sky(this.parttern));
        }
    }
}
