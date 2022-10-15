import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlusMinusButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlusButton extends Button {
    
    private int category;
    
    public PlusButton(int i) {
        this.category = i;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.category == 0) {
                if (Props.rows + 1 > 30) return; 
                Props.rows++;
            } else if (this.category == 1) {
                if (Props.cols + 1 > 16) return; 
                Props.cols++;
            } else {
                if (Props.bombs + 1 >= Props.rows * Props.cols) return; 
                Props.bombs++;
            }
        }
    }
}
