import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 传送门
 */
public class Portal extends Actor {

    private GifImage gif;

    public Portal() {
        gif = new GifImage("other/portal.gif");
    }

    public void act() {
        setImage(gif.getCurrentImage());
        /* 对于当前世界做判断：
         * 若是level1，消灭完所有敌人后进入level2；
         * 若是level2，消灭完所有敌人之后准备BOSS战
         */ 
        if (getWorld() instanceof Level1 && 
                Greenfoot.isKeyDown("space") &&
                // getWorld().getObjects(Enemy.class).size() == 0 &&
                isTouching(Role.class)) {
            transform(1);
        } else if (getWorld() instanceof Level2 &&
                Greenfoot.isKeyDown("space") &&
                // getWorld().getObjects(Enemy.class).size() == 0 &&
                isTouching(Role.class)) {
            transform(2);
        }
    }
    
    private void transform(int level) {
        Role role = getWorld().getObjects(Role.class).get(0);
        role.isStart = false;
        if (level == 1) {
            Level1.bgm.stop();
        } else if (level == 2) {
            Level2.bgm.stop();
        }
        Level2.bgm.stop();
        Music.playMusic("portal.wav", 70);
        Greenfoot.delay(50);
        if (level == 1) {
            Greenfoot.setWorld(new Level2(role));
        } else if (level == 2) {
            Greenfoot.setWorld(new Level3(role));
        }
    }
}
