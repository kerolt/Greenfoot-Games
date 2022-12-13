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
    private Ball myBall;  // �����ͷ�֮ǰʹ��
    private int reloadDelayCount = 20;//���¼����ӳ���
    private static final int gunReloadTime = 20;
    
    /**
     * �����崴��ʱ��ͬʱҲ���һ����
     */
    public void addedToWorld(World world)
    {
        newBall();
    }
    /**
     * �ڻ����а��¡�act����Run����ť���ͻ���ô˷���
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
    
    //������෽�ƶ�һ��㣨��֤�������ש��򲻵���
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myBall != null) {
            myBall.move (dist);
        }
    }
    //���һ����
    public void newBall()
    {
        myBall = new Ball();
        getWorld().addObject (myBall, getX(), getY()-22);
    }
    //�ǲ�������
    public boolean haveBall()
    {
        return myBall != null;
    }
    //�ͷ�һ����
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
