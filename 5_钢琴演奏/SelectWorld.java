import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World ѡ����
 * ����ѡ���Լ��������ѡ�����׵��࣬ͬʱ����ѡ���ɫ����ʽ
 */
public class SelectWorld extends World
{
    public SelectWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(new BackButton(), 70, 45);
        addObject(new GoButton(), 920, 45);
        
        // ѡ������
        addObject(new LeftButton("select-music"), 400, 120);
        addObject(new MusicBoard(), 600, 120);
        addObject(new RightButton("select-music"), 800, 120);

        // ѡ���ɫ����ʽ
        addObject(new LeftButton("select-block"), 400, 280);
        addObject(new BlockBoard(), 600, 280);
        addObject(new RightButton("select-block"), 800, 280);
        
        // ѡ����ٽ��汳��
        addObject(new LeftButton("select-background"), 400, 460);
        addObject(new ImageBoard(), 600, 460);
        addObject(new RightButton("select-background"), 800, 460);
    }
}
