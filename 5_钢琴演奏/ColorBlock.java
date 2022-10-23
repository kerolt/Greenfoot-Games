import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColorBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColorBlock extends Actor {
    
    private int x;
    private int y;
    private GreenfootImage rect;
    
    public ColorBlock(int x, int y) {
        this.x = x;
        this.y = y;
        this.init();
        turn(-90);
    }
    
    public void init() {
        GreenfootImage img = new GreenfootImage("block" + BlockBoard.blockIdx + ".png");
        setImage(img);
    }
    
    /**
     * ��ɫС����ڵ�ǰ�ټ������������ƶ�����������߽缴�Ƴ�
     */
    public void act() {
        move(2);
        if (getY() <= 0) {
            getWorld().removeObject(this);
        }
    }
}
