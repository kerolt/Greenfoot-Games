import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World 选择类
 * 用于选择自己弹奏或者选择乐谱弹奏，同时还可选择彩色块样式
 */
public class SelectWorld extends World
{
    public SelectWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(new BackButton(), 70, 45);
        addObject(new GoButton(), 920, 45);
        
        // 选择乐谱
        addObject(new LeftButton("select-music"), 400, 120);
        addObject(new MusicBoard(), 600, 120);
        addObject(new RightButton("select-music"), 800, 120);

        // 选择彩色块样式
        addObject(new LeftButton("select-block"), 400, 280);
        addObject(new BlockBoard(), 600, 280);
        addObject(new RightButton("select-block"), 800, 280);
        
        // 选择钢琴界面背景
        addObject(new LeftButton("select-background"), 400, 460);
        addObject(new ImageBoard(), 600, 460);
        addObject(new RightButton("select-background"), 800, 460);
    }
}
