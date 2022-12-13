import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 矿工
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Miner extends Enemy {
    
    public static int HP = 25; // 小怪生命值
    
    private static GifImage gif = new GifImage("enemy/miner.gif");
    private static int moveBufferTime = 50;
    
    public Miner() {
        super(gif, moveBufferTime, 25);
    }
}
