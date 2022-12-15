import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigGoblin extends Enemy {
    
    public static int HP = 30; // 小怪生命值
    
    private static GifImage gif = new GifImage("enemy/big-goblin.gif");
    private static int moveBufferTime = 50;
    private static int attack = 2;
    
    public BigGoblin() {
        super(gif, HP, moveBufferTime, attack);
    }
}
