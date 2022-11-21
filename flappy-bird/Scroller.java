import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  滚动体对象，用来滚动显示
 */
public abstract class Scroller extends Actor {
    
    private int player;
    
    /**
     * @param player 双人模式下，0代表左边玩家，1代表右边玩家
     */
    public Scroller(int player) {
        this.player = player;
    }
    
    //游戏循环，更新游戏逻辑
    public void act() {
        move();
    }
    
    //跟随场景进行滚动
    private void move(){
        setLocation(getX() - Bird.SPEED, getY());  //朝小鸟反方向滚动
        if (this.player == 0) {
            if (getX() <= 2) {  //若抵达左边界则从游戏场景移除
                getWorld().removeObject(this);
            }
        } else {
            if (getX() <= getWorld().getWidth() / 2 + 7) {  //若抵达左边界则从游戏场景移除
                getWorld().removeObject(this);
            }
        }
    }
}