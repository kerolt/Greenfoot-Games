import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game paddle. It is keyboard controlled (left, right, space). It also 
 * generates a new ball when it is created itself.
 * 
 * @author mik
 * @version 1.0
 */
public class Paddle extends Actor
{
    private Ball myBall;  // 在球释放之前使用
    private int reloadDelayCount = 20;//重新加载延迟数
    private static final int gunReloadTime = 20;
    
    /**
     * 当挡板创建时，同时也添加一个球
     */
    public void addedToWorld(World world)
    {
        newBall();
    }
    /**
     * 在环境中按下“act”或“Run”按钮，就会调用此方法
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown ("left")) {
            move(-9);
        }
        if (Greenfoot.isKeyDown ("right")) {
            move(9);
        }
        if (haveBall() && Greenfoot.isKeyDown ("space")) {
            releaseBall();
        }
        reloadDelayCount++;  
    }
    
    //将球向侧方移动一点点（保证不会存在砖块打不到）
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myBall != null) {
            myBall.move (dist);
        }
    }
    //添加一个球
    public void newBall()
    {
        myBall = new Ball();
        getWorld().addObject (myBall, getX(), getY()-22);
    }
    //是不是有球
    public boolean haveBall()
    {
        return myBall != null;
    }
    //释放一个球
    public void releaseBall()
    {
        myBall.release();
        myBall = null;
    }
    //
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            reloadDelayCount = 0;
            ((Board) getWorld()).counter();
        }
    }
        
}
