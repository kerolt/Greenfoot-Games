import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowMonkey extends Enemy {
    
    public static int HP = 25; // 小怪生命值
    
    private int angle = 0;
    private int counter;
    private static GifImage gif = new GifImage("enemy/snow-monkey.gif");
    private static int moveBufferTime = 80;
    
    public SnowMonkey() {
        super(gif, moveBufferTime, HP);
    }

}
