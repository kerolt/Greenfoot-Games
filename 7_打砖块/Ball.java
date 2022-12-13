import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ball of the game. It moves and bounces off the walls and the paddle.
 * 
 * @author mik
 * @version 1.0
 */
public class Ball extends Actor
{
    private int deltaX;         // x方向的速度
    private int deltaY;         // y方向的速度
    private int count = 2;
    
    private boolean stuck = true;   // 是否停住

    /**
     * 没有停下就开始运动
     */
    public void act() 
    {
        if (!stuck) 
        {
            move();
            checkOut();
        }
    }
    
    /**
     * 移动球，并检测是否碰撞到什么
     */
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        checkPaddle();
        checkWalls();
        checkBrick();
        ((Board) getWorld()).winGame();
    }
    
    /**
     * 检查是否碰撞墙，反转方向
     */
    private void checkWalls()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            deltaX = -deltaX;
        }
        if (getY() == 0) {
            deltaY = -deltaY;
        }
    }
    
    /**
     * 检查是否掉出屏幕
     */
    private void checkOut()
    {
        if (getY() == getWorld().getHeight()-1) 
        {
            ((Board) getWorld()).reduceLives();
            ((Board) getWorld()).ballIsOut();
            getWorld().removeObject(this);
            
        }
    }
    /**
     * 检查是否碰撞挡板
     */
    private void checkPaddle()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) {
            Greenfoot.playSound("sounds/cling_2.wav");
            deltaY = -deltaY;
            int offset = getX() - paddle.getX();
            deltaX = deltaX + (offset/10);
            if (deltaX > 7) {
                deltaX = 7;
            }
            if (deltaX < -7) {
                deltaX = -7;
            }
        }            
    }
    /**
     * 检查是否碰撞砖块
     */
    private void checkBrick()
    {
        Brick brick = (Brick)getOneIntersectingObject(Brick.class);
        if (brick != null) 
        {
            Greenfoot.playSound("sounds/cling_1.wav");
            deltaY = -deltaY;
            int offset = getX() - brick.getX();
            deltaX = deltaX + (offset/10);
            if (deltaX > 7) {
                deltaX = 7;
            }
            if (deltaX < -7) {
                deltaX = -7;
            }
            chancePowerUp();
            brick.effect();
        }            
    }
    
    
    /**
     * 把球侧向移动一定距离。
     */
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }

    /**
     * 把球从球拍上移开
     */
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        deltaY = -5;
        stuck = false;
    }
    /**
     * 产生道具
     */
    public void chancePowerUp()
    {
       if(Greenfoot.getRandomNumber(30) == 1)
       {
           getWorld().addObject(new NewLife(), (this.getX()), (this.getY()));
       }
       if(Greenfoot.getRandomNumber(30) == 1)
       {
           getWorld().addObject(new MultiBall(), (this.getX()), (this.getY()));
       }
       if(Greenfoot.getRandomNumber(30) == 1)
       {
           getWorld().addObject(new LazerPaddle(), (this.getX()), (this.getY()));
       }
    }
}
