import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public static int count;
    
    public Counter() {
        count = 0;
    }
    
    public void act() {
        showCnt(count);
    }
    
    public void showCnt(int cnt) {
        GreenfootImage cntMsg = new GreenfootImage(300,200);
        Font font = new Font("Ink Free",true, false,30);
        cntMsg.setFont(font);
        if (SelectImgWorld.difficulty == "easy") {
            cntMsg.drawString("count: "+ cnt, 160, 85);
        } else {
            cntMsg.drawString("count: "+ cnt, 160, 130);
        }
        setImage(cntMsg);
    }
}
