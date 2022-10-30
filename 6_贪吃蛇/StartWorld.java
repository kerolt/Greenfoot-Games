import greenfoot.*;

/**
 *  游戏世界类，贪食蛇游戏运行的场景
 */
public class StartWorld extends World
{

    //构造方法，初始化游戏设计尺寸，并添加游戏角色
    public StartWorld()
    {    
        super(1560, 550, 1); 
        addObject(new OnePlayer(),160,170);
        addObject(new TwoPlayer(),830,170);
        addObject(new TipButton(),960,30);
    }
    public void act(){
        
    }

}