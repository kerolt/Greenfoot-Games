import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 钢琴界面的背景版面图案
 */
public class ImageBoard extends Board {
    
    public static int imgIdx;
    
    public ImageBoard() {
        ImageBoard.imgIdx = 0; // 默认初始为0
    }

    public void act() {
        GreenfootImage gfi = new GreenfootImage("bg" + ImageBoard.imgIdx + ".jpg");
        gfi.scale(300, 150);
        setImage(gfi);
    }
}
