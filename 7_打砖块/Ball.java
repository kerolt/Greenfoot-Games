import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ball of the game. It moves and bounces off the walls and the paddle.
 * 
 * @author mik
 * @version 1.0
 */
public class Ball extends Actor
{
    private int deltaX;         // x������ٶ�
    private int deltaY;         // y������ٶ�
    private int count = 2;
    
    private boolean stuck = true;   // �Ƿ�ͣס

    /**
     * û��ͣ�¾Ϳ�ʼ�˶�
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
     * �ƶ��򣬲�����Ƿ���ײ��ʲô
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
     * ����Ƿ���ײǽ����ת����
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
     * ����Ƿ������Ļ
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
     * ����Ƿ���ײ����
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
     * ����Ƿ���ײש��
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
     * ��������ƶ�һ�����롣
     */
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }

    /**
     * ������������ƿ�
     */
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        deltaY = -5;
        stuck = false;
    }
    /**
     * ��������
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
