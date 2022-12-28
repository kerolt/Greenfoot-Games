import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 小鸟类，由玩家控制飞行
 */
public class Bird extends Actor {
    public static final int GRAVITY = 1;  //重力加速度
    public static final int SPEED = 5;  //水平速度
    public static final int FLAP_SPEED = -6;  //飞扬速度
    private GreenfootImage fbird1;
    private GreenfootImage fbird2;
    private GreenfootImage fbird3;
    private int speed = 0;    //垂直速度
    private int score = 0;    //分数
    private int counter = 0;  //动画计数器
    private int player;
    private int mDelay = 2;
    
    public Bird(int player) {
        this.player = player;
        this.fbird1 = new GreenfootImage("bird" + (this.player) + "_0.png");
        this.fbird2 = new GreenfootImage("bird" + (this.player) + "_1.png");
        this.fbird3 = new GreenfootImage("bird" + (this.player) + "_2.png");
        setImage(fbird2);
    }

    //游戏循环，更新小鸟的游戏逻辑
    public void act() {
        animation();
        checkClick();  
        flap();
        checkCollision();
    }

    //播放小鸟的飞行动画
    public void animation(){
        counter ++;
        if (counter == 2) {
            setImage(fbird1);
        }
        else if (counter == 4) {
            setImage(fbird2);
        }
        else if (counter == 6) {
            setImage(fbird3);
        }
        else if (counter == 8) {
            setImage(fbird2);
            counter = 0;
        }
    }

    //碰撞检测
    public void checkCollision(){
        if (isHitted()) {  //若受到冲撞，则游戏结束
            Sky.winner = (this.player + 1) % 2;
            Sky sky = (Sky) getWorld();
            Greenfoot.delay(70);
            Greenfoot.setWorld(new GameoverWorld());
        } else {  //若未受到冲撞，则检测是否得分
            checkScore();
        }
    }

    //检测事件
    private void checkClick() {
        if (Greenfoot.isKeyDown("w") && this.player == 0) {
            speed = FLAP_SPEED;
        } else if (Greenfoot.isKeyDown("up") && this.player == 1) {
            speed = FLAP_SPEED;
        }
    }

    //让小鸟飞扬
    private void flap() {
        if (this.mDelay == 0) { // 两帧才刷新一次速度
            speed = speed + GRAVITY;  //垂直速度受重力影响
            this.mDelay = 2;
        }
        setLocation(getX(), getY() + speed);  //更新坐标位置
        setRotation(speed);  //更新旋转角度
        this.mDelay--;
    }

    //检测小鸟是否受到冲撞
    private boolean isHitted() {
        if (isTouching(Pipe.class) || isTouching(Land.class)) {  //撞上水管
            Greenfoot.playSound("hitpipe.mp3");
            return true;
        }
        if (getY() >= getWorld().getHeight() - getImage().getHeight()/2) {  //撞上地面
            Greenfoot.playSound("hitground.mp3");
            return true;
        }
        return false;
    }

    //检测是否取得分数
    private void checkScore() {
        if (isTouching(HideLine.class)) {  //若接触得分条则加分
            removeTouching(HideLine.class);
            score++;
            Object obj = null;
            if (this.player == 0) {
                obj = getWorld().getObjects(Score.class).get(0);
            } else {
                obj = getWorld().getObjects(Score.class).get(1);
            }
            
            ((Score)obj).setScore(score);
        }
    }
}