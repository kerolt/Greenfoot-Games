import greenfoot.*;

/**
 * Write a description of class Crab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crab extends Actor
{
    private int flag = 0;
    public int hp = 5; // 即HP，health point，生命值
    public int score = 0; // 分数

    public void act() 
    {
        if (CrabWorld.isStart) {
            move(5);
            checkKeys();
            turnAtEdge();
            eatWorm();
            animation();
            checkWin();
        }
    }

    public void animation(){
        if(flag == 5){
            setImage("crab.png");
        }
        else if (flag == 10){
            setImage("crab2.png");
            flag = 0;
        }
        flag ++;
    }

    public void eatWorm(){
        if(isTouching(Worm.class)){
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
            
            score++;
            Score scoreText = (Score) getWorld().getObjects(Score.class).get(0);
            scoreText.setScore(score);
        }
    }

    public void turnAtEdge(){
        if(isAtEdge()){
            turn(180);
        }
    }

    public void checkKeys(){
        if(Greenfoot.isKeyDown("right")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("left")){
            turn(-5);
        }
    }
    
    public void checkWin() {
        if (getObjectsInRange(1000, Worm.class).size() == 0) {
            CrabWorld world = (CrabWorld) getWorld();
            world.addObject(new GameWin(), world.getWidth() / 2, world.getHeight() / 2 - 50);
            Greenfoot.stop();
        }
    }
}
