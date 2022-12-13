import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * 敌人
 */
public class Enemy extends Player {
    
    public int HP; // 小怪生命值
    
    private int angle = 0;
    private int counter;
    private GifImage gif;
    private int moveBufferTime; // 移动缓冲时间
    private int attackBufferTime; // 攻击缓冲时间
    private int delay;
    
    public Enemy(GifImage gif, int HP, int moveBufferTime) {
        this.gif = gif;
        this.moveBufferTime = moveBufferTime;
        this.HP = HP;
        this.delay = 0;
        this.attackBufferTime = 0;
    } 
    
    public void act() {
        setImage(gif.getCurrentImage());
        if (this.delay == 2) {
            move(angle, 2);
            this.delay = 0;
        }
        this.delay++;
        counter++;
        if (counter > this.moveBufferTime) {
            int random = Greenfoot.getRandomNumber(4);
            angle += 90 * random;
            counter = 0;
        }
        attackRole();
    }
    
    public void move(double angle, double distance) throws NullPointerException {
        int x = getX(), y = getY();
        angle = Math.toRadians(angle);
        setLocation(getX() + Math.cos(angle) * distance, getY() + Math.sin(angle) * distance);
        // 若移动以后会撞到墙，则取消这次移动，恢复之前的位置
        if (isTouching(Wall.class) || isTouching(Door.class)) {
            setLocation(x, y);
        }
    }
    
    public void attackRole() {
        List<Role> roles = getObjectsInRange(350, Role.class);
        if (roles.size() > 0) {
            if (this.attackBufferTime == 100) {
                Role role = roles.get(0);
                int targetX = role.getX();
                int targetY = role.getY();
                getWorld().addObject(new EnemyBullet(targetX, targetY, 1), getX(), getY());
                this.attackBufferTime = 0;
            }
            this.attackBufferTime++;
        }
    }
    
    public boolean isTouchWall() {
        return isTouching(Wall.class);
    }
}