import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World {
    
    public static GreenfootSound startBgm = new GreenfootSound("start-bgm.wav");
    
    public StartWorld() {    
        super(1200, 700, 1); 
        setBackground("other/start.png");
        setPaintOrder(CloseButton.class, TipPanel.class);
        addUI();
        Greenfoot.start();
        
    }
    
    public void started() {
        StartWorld.startBgm.playLoop();  
        StartWorld.startBgm.setVolume(35);
    }
    
    public void stopped() {
        StartWorld.startBgm.pause();
    }
    
    public void addUI() {
        addObject(new StartButton(), getWidth() / 2, 590);
        addObject(new TipButton(), 65, 650);
    }
}
