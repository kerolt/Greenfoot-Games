import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 角色武器子弹类
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
                    if (getWorld().getObjects(BossStrip.class).size() != 0) { // 如果是BOSS
                        getWorld().removeObject(getWorld().getObjects(BossStrip.class).get(0));
                        Level3.bgm.stop();
                        Greenfoot.delay(50);
                        Greenfoot.setWorld(new GameOverWorld(0));
                    }
                    getWorld().removeObject(enemy);
                    randomGenerateMP();
                    
                    // 播放怪物死亡的音乐
                    Music.playMusic("enemy-die.wav", 68);
                }
            }
            getWorld().removeObject(this);
        }
        attackEnemy();
    }
    
    public void attackEnemy() {
        move(8);
    }
    
    // 怪物被消灭后有1/3的概率恢复50的蓝
    public void randomGenerateMP() {
        int random = Greenfoot.getRandomNumber(3);
        if (random == 0) {
            Role.MP = Role.MP + 50 > Role.MAX_MP ? Role.MAX_MP : Role.MP + 50;
        }
    }
}
