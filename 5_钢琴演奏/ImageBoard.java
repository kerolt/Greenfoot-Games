import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ���ٽ���ı�������ͼ��
 */
public class ImageBoard extends Board {
    
    public static int imgIdx;
    
    public ImageBoard() {
        ImageBoard.imgIdx = 0; // Ĭ�ϳ�ʼΪ0
    }

    public void act() {
        GreenfootImage gfi = new GreenfootImage("bg" + ImageBoard.imgIdx + ".jpg");
        gfi.scale(300, 150);
        setImage(gfi);
    }
}
