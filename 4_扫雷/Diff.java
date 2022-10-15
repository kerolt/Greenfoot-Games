import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diff extends Actor {
    
    public static int row;
    public static int col;
    public static int bombNum;
    private String diffName;
    
    public Diff(String diff) {
        setImage(diff + ".png");
        this.diffName = diff;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.diffName == "easy") {
                Diff.row = 9;
                Diff.col = 9;
                Diff.bombNum = 10;
            } else if (this.diffName == "medium") {
                Diff.row = 16;
                Diff.col = 16;
                Diff.bombNum = 40;
            } else {
                Diff.row = 30;
                  Diff.col = 16;
                  Diff.bombNum = 99;
            }
            Greenfoot.setWorld(new GameWorld(Diff.row, Diff.col, Diff.bombNum));
        }
    }
}
