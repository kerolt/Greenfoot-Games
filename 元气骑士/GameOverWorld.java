import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World {
    
    public GameOverWorld(int type) {    
        super(1200, 700, 1); 
        setBackground("other/bg-black.jpg");
        String msg = type == 0 ? "勇敢的冒险者，你已完成了挑战！\n魔法石已经归位，感谢你的精彩付出！" : "你已死亡！！！" ;
        showText(msg, getWidth() / 2, getHeight() / 2); 
    }
}
