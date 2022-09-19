import greenfoot.*;

/**
 * Write a description of class Worm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Worm extends Actor
{
    private int flag = 0;
    /**
     * Act - do whatever the Worm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        animation();
    }    
    
    /**
     * 让虫子扭起来
     */
    public void animation(){
        if(flag == 7){
            setImage("worm.png");
        }
        else if (flag == 14){
            setImage("worm2.png");
            flag = 0;
        }
        flag ++;
    }
}
