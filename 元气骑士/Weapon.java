import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * 武器类
 */
public class Weapon extends Actor {
    
    public boolean isCatch;
    
    private int shootBufferTime;
    private boolean attackFlag;
    private int shootTime;
    private int blueConsumption; // 蓝耗
    private int attack; // 武器的攻击力
    private String weaponName; // 武器名
    
    /**
     * @param isCatch         是否被玩家拾起
     * @param shootBufferTime 射击缓冲时间
     * @param blueConsumption 该武器的蓝耗量
     * @param attack          该武器的攻击力
     */
    public Weapon(String weaponName, boolean isCatch, int shootBufferTime, int blueConsumption, int attack) {
        this.isCatch = isCatch;
        this.shootBufferTime = shootBufferTime;
        // this.attackFlag = true;
        this.shootTime = 0;
        this.blueConsumption = blueConsumption;
        this.attack = attack;
        this.weaponName = weaponName;
    }
    
    public void act() {
        roleCatch();
        attackEnemy();
    }
    
    private void roleCatch() {
        if (this.isCatch) {
            Role role = getWorld().getObjects(Role.class).get(0);
            setLocation(role.getX() + 12, role.getY() + 7);
        }
    }
    
    public void attackEnemy() {
        if (this.isCatch && this.shootTime % this.shootBufferTime == 0 && Greenfoot.isKeyDown("j") && Role.MP > 0) {
            Role.MP -= this.blueConsumption;
            // System.out.println(Role.MP);
            List<Enemy> enemyList = getObjectsInRange(200, Enemy.class);
            int targetX = getWorld().getWidth(), targetY = getWorld().getHeight() / 2;
            int angle = 0;
            if (enemyList.size() != 0) {
                int minDistance = Integer.MAX_VALUE;
                for (Enemy enemy : enemyList) {
                    int x = enemy.getX();
                    int y = enemy.getY();
                    if (Math.sqrt(x * x + y * y) < minDistance) {
                        targetX = enemy.getX();
                        targetY = enemy.getY();
                    }
                }
            }
            getWorld().addObject(new Bullet(this.weaponName, targetX, targetY, attack), getX(), getY());
        } 
        this.shootTime++;
    }
}
