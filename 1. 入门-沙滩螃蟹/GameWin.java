import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class GameWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWin extends GameUI
{
    public GameWin() {
        GreenfootImage winShow = new GreenfootImage(300, 110); 
        Font f = new Font("Comic Sans MS", 0,  30);
        winShow.setFont(f);
        winShow.setColor(Color.GREEN);
        winShow.drawString("YOU WIN !!!", 50, 50);
        setImage(winShow);
    }
}
