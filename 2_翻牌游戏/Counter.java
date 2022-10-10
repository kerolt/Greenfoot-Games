import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Message {
    public static int count;
    
    public Counter() {
        count = 0;
    }
    
    public void act() {
        showCnt(count);
    }
    
    public void showCnt(int cnt) {
        GreenfootImage cntMsg = new GreenfootImage(120,80);
        Font font = new Font("Ink Free",true, false,20);
        cntMsg.setFont(font);
        cntMsg.drawString("count: "+ cnt, 10, 20);
        setImage(cntMsg);
    }
}
