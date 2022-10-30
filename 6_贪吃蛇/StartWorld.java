import greenfoot.*;

/**
 *  游戏世界类，贪食蛇游戏运行的场景
 */
public class StartWorld extends World {
    
    //构造方法，初始化游戏设计尺寸，并添加游戏角色
    public StartWorld() {    
        super(1300, 800, 1); 
        addObject(new Logo(), getWidth() / 2, getHeight() / 2 - 150);
        addObject(new OnePlayer(),getWidth() / 2 - 160,500);
        addObject(new TwoPlayer(),getWidth() / 2 + 160,500);
        addObject(new TipButton(),1200,50);
        addObject(new MusicButton(), 1200, 750);
        Greenfoot.start();
    }
}