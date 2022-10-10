import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Time here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time extends Actor {
    public static long startTime;
    public static long tempTime;
    public static long playTime;
    public static boolean isOver;
    
    public Time() {
        startTime = 0;
        tempTime = 0;
        playTime = 0;
        this.isOver = false;
        show(360);
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
        playTime = 360 - (tempTime + (thisTime - startTime) / 1000L);
        if (playTime == 0) this.isOver = true;
    }
    
    public void show(long time) {
        GreenfootImage scoreMsg = new GreenfootImage(310, 200);
        Font font = new Font("Ink Free",true, false, 30);
        scoreMsg.setFont(font);
        if (SelectImgWorld.difficulty == "easy") {
            scoreMsg.drawString("Time: "+ time, 160, 140);
        } else {
            scoreMsg.drawString("Time: "+ time, 160, 180);
        }
        setImage(scoreMsg);
    }
}
