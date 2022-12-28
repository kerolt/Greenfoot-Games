import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * BOSS
 */
public class Boss extends Enemy {
    
    public static final int MAX_HP = 1800;
    public static int HP = 1800;
    
    private static GifImage gif = new GifImage("enemy/boss.gif");
    private static int moveBufferTime = 70;
    private int bufferTime1 = 250;
    private int bufferTime2 = 400;
    private int superAttackBuffer1; // 超级攻击1的缓冲
    private int superAttackBuffer2; // 超级攻击2的缓冲
    private int traceBuffer = 0;
    private boolean isRage; // 是否狂怒
    private boolean dropTime1 = false;
    private boolean dropTime2 = false;
    private boolean dropTime3 = false;
    private boolean dropTime4 = false;
    
    public Boss() {
        super(gif, HP, moveBufferTime, 1);
        this.superAttackBuffer1 = 0;
        this.superAttackBuffer2 = 0;
        this.isRage = true;
    }
    
    public void act() {
        super.act(); // 平A
        if (this.traceBuffer == 2) {
            traceRole();
            this.traceBuffer = 0;
        }
        this.traceBuffer++;
        superAttack();
        rage();
        dropEnergyBall();
    }
    
    // 追踪玩家
    private void traceRole() {
        Role role = getWorld().getObjects(Role.class).get(0);
        int x = role.getX();
        int y = role.getY();
        if (x < getX() && y < getY()) {
            setLocation(getX() - 1, getY() - 1);
        } else if (x > getX() && y < getY()) {
            setLocation(getX() + 1, getY() - 1);
        } else if (x < getX() && y > getY()) {
            setLocation(getX() - 1, getY() + 1);
        } else if (x > getX() && y > getY()) {
            setLocation(getX() + 1, getY() + 1);
        } else if (x == getX() && y < getY()) {
            setLocation(getX(), getY() - 1);
        } else if (x == getX() && y > getY()) {
            setLocation(getX(), getY() + 1);
        } else if (y == getY() && x < getX()) {
            setLocation(getX() - 1, getY());
        } else if (y == getY() && x > getX()) {
            setLocation(getX() + 1, getY());
        }
    }
    
    // 超级攻击~
    private void superAttack() {
        if (this.superAttackBuffer1 == this.bufferTime1) {
            attackByRadiation1();
            this.superAttackBuffer1 = 0;
        }
        this.superAttackBuffer1++;
        
        if (this.superAttackBuffer2 == this.bufferTime2) {
            attackByRadiation2();
            this.superAttackBuffer2 = 0;
        }
        this.superAttackBuffer2++;
    }
    
    // 辐射攻击1
    private void attackByRadiation1() {
        int x = getX();
        int y = getY();
        World world = getWorld();
        // 八个方位
        world.addObject(new BossBullet("BOSS子弹1", 0), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 90), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 180), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 270), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 30), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 60), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 120), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 150), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 210), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 240), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 300), x, y);
        world.addObject(new BossBullet("BOSS子弹1", 330), x, y);
    }
    
    // 辐射攻击2
    private void attackByRadiation2() {
        int x = getX();
        int y = getY();
        World world = getWorld();
        world.addObject(new BossBullet("BOSS子弹2", 0), x, y);
        world.addObject(new BossBullet("BOSS子弹2", 90), x, y);
        world.addObject(new BossBullet("BOSS子弹2", 180), x, y);
        world.addObject(new BossBullet("BOSS子弹2", 270), x, y);
    }
    
    // 狂怒状态
    private void rage() {
        // System.out.println(super.HP);
        if (super.HP <= 1700) {
            BossBullet.attack = 3;
            getWorld().showText("BOSS已经进入狂怒状态！伤害增加！攻速增加！", 420, 25);
            this.isRage = true;
            // 缩短超级攻击的时间间隔
            this.bufferTime1 = 190;
            this.bufferTime2 = 260;
        }
    }
    
    private void drop() {
        int x = getX();
        int y = getY();
        World world = getWorld();
        for (int i = 0; i < 80; i++) {
            int randomX = Greenfoot.getRandomNumber(600) - 300;
            int randomY = Greenfoot.getRandomNumber(600) - 300;
            world.addObject(new EnergyBall(), x + randomX, y + randomY);
        }
    }
    
    // 在几个时间掉落能量球
    private void dropEnergyBall() {
        if (!this.dropTime1 && super.HP <= 1600) {
            this.dropTime1 = true;
            drop();
        }
        if (!this.dropTime2 && super.HP <= 1200) {
            this.dropTime2 = true;
            drop();
        }
        if (!this.dropTime3 && super.HP <= 800) {
            this.dropTime3 = true;
            drop();
        }
        if (!this.dropTime4 && super.HP <= 400) {
            this.dropTime4 = true;
            drop();
        }
    }
    
    
}
