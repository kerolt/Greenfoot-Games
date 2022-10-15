import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MinusButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinusButton extends Button {
    
    private int category;
    
    public MinusButton(int i) {
        this.category = i;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.category == 0) {
                // 保证游戏有可玩性
                if (Props.rows - 1 < 1 || (Props.rows - 1) * Props.cols <= Props.bombs) return; 
                Props.rows--;
            } else if (this.category == 1) {
                if (Props.cols - 1 < 1 || Props.rows * (Props.cols - 1) <= Props.bombs) return; 
                Props.cols--;
            } else {
                if (Props.bombs - 1 < 1) return; 
                Props.bombs--;
            }
        }
    }
}
