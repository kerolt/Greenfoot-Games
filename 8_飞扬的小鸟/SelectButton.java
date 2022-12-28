import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectButton extends GUI {
    
    private String parttern;
    
    public SelectButton(String parttern) {
        this.parttern = parttern;
        setImage(parttern + ".png");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.parttern == "left") {
                Diff.diff = (Diff.diff - 1 + 2) % 2;
            } else {
                Diff.diff = (Diff.diff + 1) % 2;
            }
        }
    }
}
