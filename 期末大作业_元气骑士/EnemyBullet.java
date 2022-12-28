import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 敌人子弹（Boss平A时也可使用）
 */
public class EnemyBullet extends Actor {
    
    private int targetX, targetY;
    private boolean isReady;
    private int attack;
    
    public EnemyBullet(int targetX, int targetY, int attack) {
        setImage("enemy/小怪子弹.png");
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
        if (isTouching(Wall.class) || isTouching(Role.class) || isAtEdge()) {
            if (isTouching(Role.class)) {
                Role role = (Role) getOneIntersectingObject(Role.class);
                if (role.armor <= 0) {
                    role.HP -= this.attack;
                    Music.playMusic("role-hurt.wav", 70);
                } else {
                    role.armor -= this.attack;
                }
            }
            getWorld().removeObject(this);
        }
        move(3);
    }
}
