import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goblin extends Enemy {
    
    public static int HP = 15; // 小怪生命值
    
    private static GifImage gif = new GifImage("enemy/goblin.gif");
    private static int moveBufferTime = 40;
    private static int attack = 1;
    
    public Goblin() {
        super(gif, HP, moveBufferTime, attack);
    }
}
