import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombBumText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombNumText extends Text {
    
    public BombNumText() {
        show();
    }
    
    public void act() {
        show();
    }
    
    public void show() {
        GreenfootImage bombNum = new GreenfootImage(70, 25);
        bombNum.setFont(new Font("Ink Free",true, false, 25));
        bombNum.drawString("" + GameWorld.bombNum, 12, 18);
        setImage(bombNum);
    }
}
