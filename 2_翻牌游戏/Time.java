import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time extends Message {
    public static long startTime;
    public static long tempTime;
    public static long playTime;
    
    public Time() {
        startTime = 0;
        tempTime = 0;
        playTime = 0;
        show(0);
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        countTime();
        show(playTime);
    }  
    
    public void countTime() {
        long thisTime = System.currentTimeMillis();
        playTime = tempTime + (thisTime - startTime) / 1000L;
    }
    
    public void show(long time) {
        GreenfootImage scoreMsg = new GreenfootImage(120,80);
        Font font = new Font("Ink Free",true, false,20);
        scoreMsg.setFont(font);
        scoreMsg.drawString("Time: "+ time, 10, 20);
        setImage(scoreMsg);
    }
}
