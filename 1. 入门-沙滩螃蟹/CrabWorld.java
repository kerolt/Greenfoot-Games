import greenfoot.*;
import java.util.ArrayList;
/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World {
    
    public static boolean isStart = false;
    
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        gamePlay();
    }

    /**
     * 开始前先为你的剧本创建场景
     * 添加元件到你的场景
     */
    private void prepare() {
        isStart = false;
        
        Crab crab = new Crab();
        addObject(crab, 116, 130);
        Worm worm = new Worm();
        addObject(worm, 484, 218);
        Worm worm2 = new Worm();
        addObject(worm2, 541, 111);
        Worm worm3 = new Worm();
        addObject(worm3, 388, 88);
        Worm worm4 = new Worm();
        addObject(worm4, 258, 206);
        Worm worm5 = new Worm();
        addObject(worm5, 97, 285);
        Worm worm6 = new Worm();
        addObject(worm6, 188, 320);
        Worm worm7 = new Worm();
        addObject(worm7, 464, 350);
        Worm worm8 = new Worm();
        addObject(worm8, 313, 290);
        Worm worm9 = new Worm();
        addObject(worm9, 161, 22);
        Worm worm10 = new Worm();
        addObject(worm10, 275, 53);
        Worm worm11 = new Worm();
        addObject(worm11, 367, 208);
        Lobster lobster = new Lobster();
        addObject(lobster, 61, 235);
        crab.setLocation(207, 137);
        
        HP hp = new HP();
        addObject(hp, 125, 20);
        Score score = new Score();
        addObject(score, 125, 60);
        
    }
    
    public void gameOver() {
        addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
    
    public void gamePlay() {
        addObject(new GamePlay(), getWidth() / 2, getHeight() / 2 + 150);
    }
}
