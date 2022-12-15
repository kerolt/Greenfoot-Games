import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * BOSS血条
 */
public class BossStrip extends Actor {
    
    public BossStrip() {
    }
    
    public void act() {
        List<Boss> bossList = getWorld().getObjects(Boss.class);
        if (bossList.size() > 0) {
            Boss boss = bossList.get(0);
            setLocation(boss.getX(), boss.getY() - 60);
            changeBloodStrip();
        }
    }
    
    private void changeBloodStrip() {
        GreenfootImage strip = new GreenfootImage(402, 22); 
        Enemy enemy = getWorld().getObjects(Boss.class).get(0);
        
        // 红色血条
        strip.setColor(Color.RED);
        strip.fillRect(0, 0, (int)((double)enemy.HP / Boss.MAX_HP * 400),20);
        strip.setColor(Color.BLACK);
        
        // 黑色血条框
        strip.drawLine(0, 0, 400, 0);
        strip.drawLine(0, 20, 400, 20);
        strip.drawLine(0, 0, 0, 20);
        strip.drawLine(400, 0, 400, 20);
        
        setImage(strip);
    }
}
