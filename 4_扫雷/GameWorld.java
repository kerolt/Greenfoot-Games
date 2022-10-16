import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
/**
 * 游戏世界类，用来提供游戏进行的场景
 */
public class GameWorld extends World{
    
    private ArrayList<Block> blocks = new ArrayList<Block>();  //方块列表，管理游戏中所有方块
    public int m_bombNum; // 地雷数量
    public static int bombNum ;
    public static boolean isOver = false;  // 游戏是否结束
    public static int diff;  // 游戏难度
    public static boolean end;  // true代表获胜，false代表失败
    
    //构造方法，用来为游戏世界添加初始对象
    public GameWorld(int row, int col, int bombNum){    
        super(34, 21, 25);    
        this.m_bombNum = bombNum;
        this.bombNum = bombNum;
        Diff.row = row;
        Diff.col = col;
        Diff.bombNum = bombNum;
        GameWorld.isOver = false;
        Block.isStartGame = false;
        Block.isFirstClick = true;
        int startX = 17 - row / 2;
        int startY = 11 - col / 2;
        if (row == 9 && col == 9) {
            startY = 4;
        }
        addObject(new ReturnButton(), 1, 1);
        addObject(new TimeIcon(), 14, 1);
        addObject(new TimeText(), 13, 1);
        addObject(new SmileIcon(), 17, 1);
        addObject(new BombNumIcon(), 20, 1);
        addObject(new BombNumText(), 22, 1);
        for (int i = startX; i < row + startX; i++) {   //对于游戏世界的每一列，
            for (int j = startY; j < col + startY; j++) { //对于游戏世界的每一行，
                Block block = new Block();        //创建方块对象
                blocks.add(block);                //加入方块列表
                addObject(block, i, j);           //添加至游戏世界
            }
        }
        Collections.shuffle(blocks);    //打乱方块列表中各个方块的顺序
        for (int i = 0; i < this.m_bombNum; i++) {      //对于方块列表中的前20个方块，
            blocks.get(i).setBomb();      //在其下设置地雷
        }

    }
    
    //显示所有的地雷
    public void showAllBomb() {
        for (int i=0; i<this.m_bombNum; i++) {           //对于方块列表中的所有地雷方块，
            blocks.get(i).setImage("Bomb.png"); //将其图像设置为地雷
            //Greenfoot.delay(1);
        }
    }
    
    //更新游戏逻辑，游戏每帧执行一次
    public void act() {
        for (int i=0; i<this.m_bombNum; i++) {        //对于方块列表中的所有地雷方块，
            if (!blocks.get(i).getFlag()) { //若其没有插上旗子，则
                return;                       //返回
            }            
        }
        gameOver(true);
    }
    
    public void gameOver(boolean end) {
        if (!end) {  // 如果游戏失败
            showAllBomb();                     //显示世界中所有的地雷
            Greenfoot.playSound("bomb.wav");         //播放爆炸音效
            getObjects(SmileIcon.class).get(0).setImage("cry.png");
        } else {
            Greenfoot.playSound("win.wav");  //播放获胜的声音
        }
        GameWorld.isOver = true;
        Greenfoot.delay(30);
        addObject(new Board(), getWidth() / 2, getHeight() / 2 + 1);
        if (!end) {
            addObject(new FailIcon(), 12, 8);
        } else {
            addObject(new SuccessIcon(), 12, 8);
        }
        showText("" + TimeText.playTime, 23, 10);
        showText("" + Diff.bombNum, 10, 15);
        showText("" + Diff.row, 16, 15);
        showText("" + Diff.col, 18, 15);
        String tempDiff;
        switch (GameWorld.diff) {
            case 0: tempDiff = "简单"; break;
            case 1: tempDiff = "中等"; break;
            case 2: tempDiff = "困难"; break;
            default: tempDiff = "自定义"; break;
        }
        showText(tempDiff, 23, 15);
    }
    
    public void started() {
        TimeText.startTime = System.currentTimeMillis();   
    }
    
    public void stopped() {
        TimeText.tempTime = TimeText.playTime;
    }
}
