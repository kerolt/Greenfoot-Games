import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Head here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Head extends Actor {

    private ArrayList<Piece> body; // body列表用来保存蛇身
    private int length; // 蛇身长度
    private int speed; // 蛇头移动速度
    private int direction; // 蛇头移动方向
    private int colorFoodNum; // 吃到的彩色小食物的数量 
    private int botTurnTime; // 控制人机转向时间
    //public boolean isOver;
    
    public int player;
    public final int SOUTH = 0; // 该常量代表向下移动
    public final int NORTH = 1; // 该常量代表向上移动
    public final int EAST = 2; // 该常量代表向右移动
    public final int WEST = 3; // 该常量代表向左移动

    /**
     * @param player 玩家类型：1和2都为真人，3为电脑
     */
    public Head(int player) {
        this.body = new ArrayList<Piece>();
        this.length = 1;
        this.speed = getImage().getAwtImage().getWidth();
        this.colorFoodNum = 0;
        this.botTurnTime = 45;
        this.player = player;
        if (this.player == 0) {
            setImage("head-blue.png");
        } else if (this.player == 1) {
            setImage("head-pink.png");
        } else if (this.player == 2) {
            setImage("head-bot.png");
        }
    }

    /**
     * 处理游戏逻辑
     */
    public void act() {
        // 只有当游戏已经开始并且未结束时小蛇才可以运动
        // 开始标志：按下回车键
        // 结束标志：某一条小蛇撞墙或者碰到另一条小蛇的身体
        if (GameWorld.isStart && !GameWorld.isOver) {
            checkKeydown();
            if (this.player == 0 || this.player == 1) {
                move(4);
            } else {
                botRandomMove();
            }
            updateBody();
            checkTouchOtherBody();
            checkFood();
            checkGameOver();
        }
    }
    
    /**
     * 检测是否碰到其他玩家小蛇的身体
     */
    public void checkTouchOtherBody() {
        if (isTouching(Piece.class)) {
            // 获取碰到的Piece对象
            Piece p = (Piece)getOneIntersectingObject(Piece.class);
            // 如果获取的Piece对象不是自己的，则己方败，游戏结束
            if (p.player != this.player) {
                //System.out.println("player" + this.player +  ", you loss!");
                GameWorld.isOver = true;
                GameWorld world = (GameWorld)getWorld();
                world.gameOver(GameWorld.pattern, this.player);
            }
        }
            
    }

    /**
     * 检查是否获取食物
     */
    public void checkFood() {
        // 吃到"body+3"食物
        if (isTouching(BallFood.class)) { // 若蛇头碰到食物，且蛇身未达到上限，则
            this.length += 3; // 蛇身长度增加3个单位
        }
        
        // 吃到“彩色小块”食物
        if (isTouching(ColorFood.class)) {
            if (this.player == 2) {     // 若是人机（给人机加buff~），则吃到一个彩色块就可以长大一个单位
                this.colorFoodNum += 4;
            } else {
                this.colorFoodNum++;    // 若是玩家，每次吃一个彩色块只能长1/4，即需要吃四个彩色快才可以长大一个单位
            }
        }
        
        // 吃到“磁铁”食物
        if (isTouching(MagentFood.class)) {
            // 吃到磁铁后可以直接吸收周围半径为120范围内的彩色块食物
            List<ColorFood> list = getObjectsInRange(120, ColorFood.class);
            GameWorld world = (GameWorld)getWorld();
            world.removeObjects(list);
            // 重新计算游戏世界中的彩色块数量，小于800时GameWorld类会自动补充
            GameWorld.colorFoodNumber -= list.size();  
            // 应该增加的长度
            int len = list.size() / 4;                 
            this.length += len;
            // 重新计算当前小蛇吃掉的彩色块数量 
            this.colorFoodNum += list.size() - len;    
        } 
        
        if (this.colorFoodNum >= 4) {
            this.length++;
            this.colorFoodNum -= 4;
        }
    }

    /**
     * 更新贪食蛇身体
     */
    public void updateBody() {
        if (length > 1) {
            if (body.size() == length) {
                body.remove(0); // 从蛇身列表中移除蛇尾对应的Body对象
            }
            
            // 由于可能有两条蛇，我们需要正确地将当前操控的蛇对象的蛇身移除
            GameWorld w = (GameWorld)getWorld();
            List<Piece> list = w.getObjects(Piece.class);
            List<Piece> removeList = new ArrayList<>();
            for (Piece p : list) {
                if (p.player == this.player) {
                    removeList.add(p);
                }
            }
            w.removeObjects(removeList); // 将蛇身从游戏世界中移除
            
            for (Piece b : body) { // 根据蛇身各部分的位置重新添加至游戏世界
                w.addObject(b, b.getLocX(), b.getLocY());
            }
            body.add(new Piece(getX(), getY(), this.player)); // 将蛇头对应的Body对象添加至蛇身列表
        }
    }

    /**
     * 控制蛇头朝不同方向移动
     */
    @Override
    public void move(int speed) {
        switch (direction) {
            case SOUTH:
                setLocation(getX(), getY() + speed);
                break;
            case NORTH:
                setLocation(getX(), getY() - speed);
                break;
            case EAST:
                setLocation(getX() + speed, getY());
                break;
            case WEST:
                setLocation(getX() - speed, getY());
                break;
        }
    }

    /**
     * 检查游戏是否结束
     */
    public void checkGameOver() {
        if (isAtEdge()) {                               // 若蛇头碰到窗口边界或是蛇身，则
            if (this.player == 0 || this.player == 1) { // 若该玩家是真人（0 1）
                GameWorld.isOver = true;
                GameWorld world = (GameWorld)getWorld();
                world.gameOver(GameWorld.pattern, this.player);
            } else {                                    // 对于机器人（2），碰到边缘会掉头
                switch (this.direction) {
                    case 0: this.direction = 1; break;
                    case 1: this.direction = 0; break;
                    case 2: this.direction = 3; break;
                    case 3: this.direction = 2; break;
                }
            }
        }
    }

    /**
     * 检测键盘按键事件，若按下方向键，则分别控制贪食蛇朝相应方向移动
     */
    public void checkKeydown() {
        if (this.player == 0) {
            if (Greenfoot.isKeyDown("w") && direction != SOUTH) {
                direction = NORTH;
                setRotation(180);
            } else if (Greenfoot.isKeyDown("s") && direction != NORTH) {
                direction = SOUTH;
                setRotation(0);
            } else if (Greenfoot.isKeyDown("a") && direction != EAST) {
                direction = WEST;
                setRotation(90);
            } else if (Greenfoot.isKeyDown("d") && direction != WEST) {
                direction = EAST;
                setRotation(270);
            } 
        } else if (this.player == 1) {
            if (Greenfoot.isKeyDown("up") && direction != SOUTH) {
                direction = NORTH;
                setRotation(180);
            } else if (Greenfoot.isKeyDown("down") && direction != NORTH) {
                direction = SOUTH;
                setRotation(0);
            } else if (Greenfoot.isKeyDown("left") && direction != EAST) {
                direction = WEST;
                setRotation(90);
            } else if (Greenfoot.isKeyDown("right") && direction != WEST) {
                direction = EAST;
                setRotation(270);
            }
        }
    }

    /**
     * 人机随机移动
     */
    public void botRandomMove() {
        if (this.botTurnTime-- == 0) {
            int direction = Greenfoot.getRandomNumber(4);
            this.direction = direction;
             //自定义move
            this.botTurnTime = 50;
        }
        move(4);
    }
}
