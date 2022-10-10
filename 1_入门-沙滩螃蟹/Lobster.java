import greenfoot.*;

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lobster extends Actor {
    private int fullTime = 60;
    private boolean fullFlag = false; // 用于判断龙虾是否饱了

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (CrabWorld.isStart) {
            randomMove();
            turnAtEdge();
            turnToCrab();
            full();
        }

    }

    public void randomMove() {
        int deg;
        deg = Greenfoot.getRandomNumber(90) - 45;
        if (Greenfoot.getRandomNumber(100) < 20) {
            turn(deg);
        }
        move(2);
    }

    public void turnAtEdge() {
        if (isAtEdge()) {
            turn(180);
        }
    }

    public void eatCrab() {
        if (isTouching(Crab.class)) {
            fullFlag = true; // 表示龙虾吃到螃蟹后进入饱腹状态，一定时间内不会再吃螃蟹
            fullTime = 60; // 设置饱腹持续时间
            Crab crab = (Crab) getIntersectingObjects(Crab.class).get(0);
            HP hpText = (HP) getWorld().getObjects(HP.class).get(0);
            int hp = --crab.hp;
            hpText.setHp(hp);
            // System.out.println("螃蟹当前生命值为：" + crab.hp);
            Greenfoot.playSound("au.wav");

            if (hp == 0) { // 当螃蟹生命值为0时结束游戏
                // System.out.println("游戏结束");
                CrabWorld world = (CrabWorld) getWorld();
                world.gameOver();
            }
        }

    }

    public void full() {
        if (fullFlag) {
            if (--fullTime == 0) {
                fullFlag = false;
            }
        } else { // 只有当龙虾吃了螃蟹后才会进入饱腹状态
            eatCrab();
        }
    }

    public void turnToCrab() {
        Crab crab = (Crab) getWorld().getObjects(Crab.class).get(0);
        turnTowards(crab.getX(), crab.getY());
    }
}
