import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends UI {
    public Title() {
        GreenfootImage title = new GreenfootImage(600, 130);
        Font f = new Font("Ink Free", false, false, 80);
        title.setFont(f);
        title.drawString("Flop Game", 125 , 100);
        setImage(title);
    }
}