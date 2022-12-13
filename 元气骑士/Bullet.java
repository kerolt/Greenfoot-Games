import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 子弹类
 */
public class Bullet extends Actor {
    
    private int targetX, targetY;
    private boolean isReady;
    private int attack;
    
    public Bullet(String weaponName, int targetX, int targetY, int attack) {
        setImage("weapon/" + weaponName + "子弹.png");
        this.targetX = targetX;
        this.targetY = targetY;
        this.isReady = true;
        this.attack = attack;
    }
    
    public void act() {
        if (this.isReady) {
            turnTowards(targetX, targetY);
            this.isReady = false;
        }
        
        if (isTouching(Wall.class) || isTouching(Enemy.class) || isAtEdge()) {
            if (isTouching(Enemy.class)) {
                Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
                // System.out.println(enemy.HP);
                enemy.HP -= this.attack;
                if (enemy.HP <= 0) { // 当怪物的血量低于或等于0时被移除
                    getWorld().removeObject(enemy);
                    randomGenerateMP();
                }
            }
            getWorld().removeObject(this);
        }
        attackEnemy();
    }
    
    public void attackEnemy() {
        move(8);
    }
    
    // 怪物被消灭后有1/4的概率恢复50的蓝
    public void randomGenerateMP() {
        int random = Greenfoot.getRandomNumber(4);
        if (random == 0) {
            Role.MP = Role.MP + 50 > Role.MAX_MP ? Role.MAX_MP : Role.MP + 50;
        }
    }
}
