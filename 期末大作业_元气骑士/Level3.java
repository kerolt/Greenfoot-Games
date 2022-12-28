import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level3,BOSS战
 */
public class Level3 extends ScrollingWorld {
    
    public static GreenfootSound bgm = new GreenfootSound("level3-bgm.wav");
    
    private Role role;
    
    public Level3(Role role) {
        super(1200, 700, 1);
        this.role = role;
        setScrollingBackground(new GreenfootImage("other/bg-gray.jpg"));
        createWorld();
        showText("LEVEL 3", 150, 25);
        Level3.bgm.playLoop();  
        Level3.bgm.setVolume(20);
    }
    
    public void started() {
        Level3.bgm.playLoop();  
        Level3.bgm.setVolume(20);
    }
    
    public void stopped() {
        Level3.bgm.pause();
    }
    
    public void createWorld() {
        addObject(this.role, getWidth() / 2, getHeight() / 2);
        addObject(new Boss(), getWidth() / 2, getHeight() / 2 - 200);
        addObject(new BossStrip(), getWidth() / 2, getHeight() / 2 - 200);
    }
}
