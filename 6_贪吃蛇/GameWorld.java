import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class SnakeWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameWorld extends World {

    public static int colorFoodNumber; // 彩色小食物的数量
    public static boolean isOver;
    public static boolean isStart; 
    public static Timer timer;
    public static boolean ballState;
    public static boolean magentState;
    public static String pattern; // 单人（single）或者双人（double）
    public int clock; //时钟数
        
    public GameWorld(String pattern) {
        super(1300, 800, 1);
        GameWorld.colorFoodNumber = 1000; // 初始化为1000
        GameWorld.isOver = false;
        GameWorld.isStart = false;
        GameWorld.ballState = false;
        GameWorld.magentState = false;
        GameWorld.pattern = pattern;
        this.clock = 0;
        init();
        Greenfoot.start();
    } 
    
    public void started() {
        this.timer=new Timer();
        this.timer.schedule(new TimerTask() {
            public void run() {
                clock++;
            }
        }, 0, 1000);
    }
    
    public void stopped() {
        if (this.timer != null) {
            this.timer.cancel();
        }
    }
    
    public void act() {
        // 检查彩色小块的数量，小于临界值时刷新
        checkColorFoodNumber();
        // 按下回车键游戏开始（整局游戏只会执行一次）
        if (!this.isStart && Greenfoot.isKeyDown("enter")) {
            removeObject(getObjects(TipBoard.class).get(0));
            removeObject(getObjects(BackButton.class).get(0));
            this.isStart = true;
            // 创建计时器,每秒时钟数+1
            if (this.timer != null) {
                this.clock = 0;
                this.timer.cancel();
            }
            this.timer=new Timer();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    //System.out.println(clock++);
                    clock++;
                }
            }, 0, 1000);
        }
        refreshFood();
    }
    
    /**
     * 初始化界面，用于添加一些角色
     */
    public void init() {
        addObject(new Head(0), 50, 30);
        // 如果时single，即单人模式，将于电脑对战
        // 如果为double，即双人模式，两名玩家对战
        if (this.pattern == "single") {
            addObject(new Head(2), 1250, 30);
        } else if (this.pattern == "double") {
            addObject(new Head(1), 1250, 30);
        }
        addObject(new BallFood(), 10 + Greenfoot.getRandomNumber(1250), 1 + Greenfoot.getRandomNumber(750));
        addObject(new MagentFood(), 10 + Greenfoot.getRandomNumber(1250), 1 + Greenfoot.getRandomNumber(750));
        addObject(new TipBoard(), getWidth() / 2, getHeight() / 2);
        addObject(new BackButton(), 70, 750);
        setPaintOrder(GameOver.class, TipBoard.class, BackButton.class, SettlementBoard.class, Head.class, Piece.class, MagentFood.class, BallFood.class, ColorFood.class);
        createColorFood(1000);
        Greenfoot.setSpeed(50); // 1~100
    }
    
    /**
     * 刷新食物
     */
    public void refreshFood() {
        // 刷新“篮球”食物
        if (GameWorld.ballState && this.clock % 5 == 0) {
            addObject(new BallFood(), 10 + Greenfoot.getRandomNumber(1200), 10 + Greenfoot.getRandomNumber(700));
            GameWorld.ballState = false;
        }
        // 刷新“磁铁”食物
        if (GameWorld.magentState && this.clock % 15 == 0) {
            addObject(new MagentFood(), 10 + Greenfoot.getRandomNumber(1200), 10 + Greenfoot.getRandomNumber(700));
            GameWorld.magentState = false;
        }
    }
    
    /**
     * 根据指定参数大小创建彩色食物
     * @param num 需要创建的彩色食物的数量
     */
    public void createColorFood(int num) {
        for (int i = 0; i < num; i++) {
            int r = Greenfoot.getRandomNumber(256);
            int g = Greenfoot.getRandomNumber(256);
            int b = Greenfoot.getRandomNumber(256);
            int randomX = 5 + Greenfoot.getRandomNumber(1280);
            int randomY = 5 + Greenfoot.getRandomNumber(780);
            addObject(new ColorFood(r, g, b), randomX, randomY);
        }
    }
    
    /**
     * 检查彩色食物的数量，小于临界值时需要添加
     */
    public void checkColorFoodNumber() {
        if (GameWorld.colorFoodNumber <= 800) {
            List<ColorFood> list = getObjects(ColorFood.class);
            createColorFood(1000 - list.size());
            GameWorld.colorFoodNumber = 1000;
        }
    }
    
    /**
     * 游戏结束
     */
    public void gameOver(String pattern, Integer player) {
        MusicButton.bgSound.pause();
        GreenfootSound sound = new GreenfootSound("over.mp3");
        sound.play();
        Greenfoot.delay(100);
        addObject(new GameOver(), getWidth() / 2, 0);
        addObject(new SettlementBoard(pattern, player), getWidth() / 2, 800);
        addObject(new BackButton(), 70, 750);
        MusicButton.bgSound.playLoop();
        
    }
}
