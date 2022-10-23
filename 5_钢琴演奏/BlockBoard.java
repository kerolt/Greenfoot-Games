import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlockBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockBoard extends Board {
    
    public static int blockIdx;
    
    public BlockBoard() {
        BlockBoard.blockIdx = 0; // Ĭ�ϳ�ʼΪ0
    }

    public void act() {
        GreenfootImage gfi = new GreenfootImage("block" + BlockBoard.blockIdx + ".png");
        gfi.scale(50, 50);
        gfi.rotate(-90);
        setImage(gfi);
    }
}
