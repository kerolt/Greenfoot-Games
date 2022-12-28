import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 天空类，提供游戏进行的场景
 */
public class Sky extends World {
    public static int PIPES_SPACING;  //上下水管间的距离 160、230
    public static final int PIPE_MIN_HEIGHT = 50;  //水管的最小高度
    public static boolean isPaused = true; //游戏的运行状态
    public static int pipeWidth;
    public static int pipeHeight;
    public static int parttern = 0;
    public static int winner; // 双人模式下的赢家
    
    private int division; // 双人时分割线在中间；单人时在最右边
    private int PIPE_INTERVAL;  //两队水管的间隔距离 80、60
    private int pipeTimer = 0;  //生成下一对水管的时间
    private int scrollX = 0;  //水平滚动坐标
    private int scrollSpeed = 1;  //滚动速度
    private GreenfootImage backIm1,backIm2;  //保存背景图像
    private GreenfootSound music; //场景音乐

    //构造方法，初始化游戏场景
    public Sky(int parttern) {
        super(1200, 700, 1,false);  //第4个参数设为false使得角色能够添加至窗口之外
        isPaused = true;
        this.parttern = parttern;
        this.division = parttern == 0 ? getWidth() : getWidth() / 2;
        this.PIPES_SPACING = Diff.diff == 0 ? 230 : 150;
        this.PIPE_INTERVAL = Diff.diff == 0 ? 90 : 60;
        pipeTimer = PIPE_INTERVAL * 2;
        backIm1 = backIm2 = new GreenfootImage(getBackground());
        music = new GreenfootSound("Harder Better Faster Stronger.mp3"); 
        setPaintOrder(GameOver.class, Score.class, Bird.class, Ready.class, Go.class, Division.class, Land.class, Pipe.class);
        init();
    }

    public void init() {
        TopPipe tp = new TopPipe(0);
        BottomPipe bp = new BottomPipe(0);
        Land land = new Land();
        int size = getWidth() / land.getImage().getWidth() + 1;
        int x = land.getImage().getWidth() / 2;
        int offset = 0;
        int width = land.getImage().getWidth();
        // 生成地面
        for (int i = 0; i < size; i++) {
            addObject(new Land(), x + offset, 680);
            offset += width;
        }
        
        // 单人和双人模式下部分角色的位置不同
        int scorePosition = this.parttern == 0 ? getWidth() / 2 : getWidth() / 4;
        int birdPosition = this.parttern == 0 ? 150 : 60;
        addObject(new Score(), scorePosition, 70);
        addObject(new Bird(0), birdPosition, 260);
        
        // 双人模式
        if (this.parttern == 1) {
            addObject(new Bird(1), getWidth() / 2 + 70, 260);
            addObject(new Division(), getWidth() / 2, getHeight() / 2);
            addObject(new Score(), getWidth() * 3 / 4, 70);
        }
    }
    
    //游戏循环，更新游戏逻辑
    public void act() {
        if(!isPaused){
            // music.playLoop();  //播放场景音乐
            addPipePairPeriodically();  //添加水管
            scrollBackground();  //滚动场景图像
        } else {
            // 准备
            Ready ready = new Ready();
            Go go = new Go();
            addObject(ready, getWidth() / 2, getHeight() / 2);
            Greenfoot.delay(60);
            removeObject(ready);
            addObject(go, getWidth() / 2, getHeight() / 2);
            Greenfoot.delay(60);
            removeObject(go);
            this.isPaused = false;
        }
    }    

    //每隔一段时间自动生成水管
    private void addPipePairPeriodically() {
        pipeTimer--;
        if (pipeTimer == 0) {
            addPipePair();
            pipeTimer = PIPE_INTERVAL;
        }
    }

    //添加一对水管，高度随机生成
    private void addPipePair() {      
        TopPipe top = new TopPipe(0);
        BottomPipe bottom = new BottomPipe(0);
        
        int pipeHeight = top.getImage().getHeight() / 2;
        int topHeight = Greenfoot.getRandomNumber(pipeHeight);
        int bottomHeight = topHeight + pipeHeight + PIPES_SPACING + top.getImage().getHeight() / 2;
        int hideY = pipeHeight + topHeight + PIPES_SPACING / 2 - 1;
        int hideX0 = getWidth() / 2 - 10  - top.getImage().getWidth() / 2;
        int hideX1 = getWidth() - 10  - top.getImage().getWidth() / 2;
        
        addObject(top , this.division - 10,  topHeight);        
        addObject(bottom , this.division - 10 , bottomHeight);
        addObject(new HideLine(0), this.division - 10 - top.getImage().getWidth() / 2, hideY);
        
        if (this.parttern == 1) {
            addObject(new TopPipe(1) , getWidth() - 25,  topHeight);
            addObject(new BottomPipe(1) , getWidth() - 25 , bottomHeight);
            addObject(new HideLine(1), hideX1, hideY);
        }
    }

    //重新设置场景图像
    public void resetBackImage(){
        GreenfootImage back = getBackground();
        back.drawImage(backIm1, scrollX, 0);
        back.drawImage(backIm2, scrollX + getWidth(), 0);
    }

    //滚动场景图像
    public void scrollBackground(){
        scrollX = (scrollX - scrollSpeed) % getWidth(); //循环滚动
        resetBackImage();
    }
}