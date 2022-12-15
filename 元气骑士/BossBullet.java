import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BOSS子弹
 */
public class BossBullet extends Actor {
    
    public static int attack = 2;
    
    public BossBullet(String bulletName, int rotation) {
        BossBullet.attack = 2;
        setImage("enemy/" + bulletName + ".png");
        turn(rotation);
    }
    
    public void act() {
        attackRole();
        move(4);
    }
    
    private void attackRole() {
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
    }
}
