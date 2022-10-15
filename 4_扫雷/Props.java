import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Props here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Props extends Actor {
    
    public static int rows = 15;
    public static int cols = 9;
    public static int bombs = 9;
    private int category;
    
    public Props(int i) {
        this.category = i;
    }
    
    public void act() {
        show();
    }
    
    public void show() {
        GreenfootImage text = new GreenfootImage(50, 50);
        text.setFont(new Font("微软雅黑",true, false, 27));
        
        if (this.category == 0) {
            text.drawString("" + Props.rows, 0, 35);
        } else if (this.category == 1) {
            text.drawString("" + Props.cols, 0, 35);
        } else {
            text.drawString("" + Props.bombs, 0, 35);
        }
        
        this.setImage(text);
    }
}
