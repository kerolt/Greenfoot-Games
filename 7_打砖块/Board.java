import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The game board. The board had a paddle that can move.
 * 
 * @author mik
 * @version 1.0
 */
public class Board extends World
{
    private Paddle paddle;
    private Brick brick;
    private int livesCount;
    private boolean paddlePower = false;
    private int counter = 0;

    /**
     * 构造函数
     */
    public Board()
    {    
        
        super(460, 520, 1);
        setPaintOrder (ScoreBoard.class,Ball.class);
        livesCount = 3;
        paddle = new Paddle();
        addObject ( paddle, getWidth() / 2, getHeight() - 50);
        addObject(new Tip("按空格发射！"),getWidth()/2, getHeight()/2);
        makeBricks();
        lives();
        counter();
    }
    

    
    //查看球的数量，是1返回true，不是返回false
    public boolean checkBallNumber()
    {
        if(super.getObjects(Ball.class).size() != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //减少生命
    public void reduceLives()
    {
        if(checkBallNumber())
        {
            livesCount--;
            lives();
        }
    }
    //增加生命
    public void increaseLives()
    {
        livesCount++;
        lives();
    }
    //球掉下去的处理
    public void ballIsOut()
    {
        if(checkBallNumber())
        {
            paddle.newBall();
        }
    }

    public void makeBricks()
    {
        for(int i=1;i<14;i++){
            addObject(new Brick(3), (i*35)- 16, (90));
        }
        for(int i=1;i<14;i++){
            addObject(new Brick(2), (i*35)- 16, (60));
        }
        for(int i=1;i<14;i++){
            addObject(new Brick(1), (i*35)- 16, (30));
        }
    }
    //检查生命数
    public void lives()
    {
        if(livesCount == -1)
        {
            super.addObject (new ScoreBoard("Game Over"), getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
        List<Lives> actors = getObjects(Lives.class); 
        for(Actor a : actors) 
        {
            removeObject(a); 
        }
        int x = 440;
        for(int i = 0; i < livesCount; i++)
        {
            super.addObject ( new Lives(), x, 500);
            x = x -30;
        }
    }
    
    public void paddlePower()
    {
        paddlePower = true;
        counter = 20;
        
    }
    
    public void counter()
    {
        counter--;
        if(counter <= 0)
        {
            paddlePower = false;
        }
    }
    
    
    public void winGame()
    {
        if(super.getObjects(Brick.class).size() <= 0)
        {
            super.addObject (new ScoreBoard("You Win! :)"), getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }
   
}
