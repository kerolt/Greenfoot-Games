import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piece here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piece extends Actor {

    private int locX; // 蛇身横坐标值
    private int locY; // 蛇身纵坐标值
    public int player;

    // 构造方法
    public Piece(int x, int y, int player) {
        locX = x;
        locY = y;
        this.player = player;
        if (this.player == 0) {
            setImage("body-blue.png");
        } else if (this.player == 1) {
            setImage("body-pink.png");
        } else if (this.player == 2) {
            setImage("body-bot.png");
        }
    }

    // 获取横坐标值
    public int getLocX() {
        return locX;
    }

    // 获取纵坐标值
    public int getLocY() {
        return locY;
    }

    public void act() {

    }
}
