import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeText extends Text {
    
    public static long startTime;
    public static long tempTime;
    public static long playTime;
    
    public TimeText() {
        startTime = 0;
        tempTime = 0;
        playTime = 0;
        show(0);
    }
    
    public void act() {
        countTime();
        show(playTime);
    }
    
    public void countTime() {
        if (!GameWorld.isOver) {
            long thisTime = System.currentTimeMillis();
            playTime = tempTime + (thisTime - startTime) / 1000L;
        }
    }
    
    public void show(long t) {
        GreenfootImage time = new GreenfootImage(70, 25);
        time.setFont(new Font("Ink Free",true, false, 25));
        String tt = Block.isStartGame ? "" + t : "0";
        time.drawString(tt, 12, 18);
        setImage(time);
    }
}
