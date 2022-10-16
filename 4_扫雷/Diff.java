import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diff extends Actor {
    
    public static int row;
    public static int col;
    public static int bombNum;
    private String diffName;
    private int speed;
    private int width;
    private int height;
    
    public Diff(String diff) {
        setImage(diff + ".png");
        this.diffName = diff;
        this.speed = 1;
    }
    
    public void act() {
        changeSize();
        checkClick();
    }

    /**
     * 改变图片大小，形成动画效果
     */
    public void changeSize() {
        GreenfootImage img = getImage();
        int curWidth = img.getWidth();
        int curHeight = img.getHeight();
        if (curWidth == 150) {
            this.speed = -this.speed;
        } else if (curWidth == 80) {
            this.speed = -this.speed;
        }
        
        img.scale(curWidth + this.speed, curHeight + this.speed);
        GreenfootImage tempImage = new GreenfootImage(this.diffName + ".png");
        tempImage.scale(img.getWidth(), img.getHeight());
        setImage(tempImage);
    }
    
    /**
     * 点击事件
     */
    public void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            if (this.diffName == "easy") {
                Diff.row = 9;
                Diff.col = 9;
                Diff.bombNum = 10;
                GameWorld.diff = 0;
            } else if (this.diffName == "medium") {
                Diff.row = 16;
                Diff.col = 16;
                Diff.bombNum = 40;
                GameWorld.diff = 1;
            } else {
                Diff.row = 30;
                Diff.col = 16;
                Diff.bombNum = 99;
                GameWorld.diff = 2;
            }
            Greenfoot.setWorld(new GameWorld(Diff.row, Diff.col, Diff.bombNum));
        }
    }
}
