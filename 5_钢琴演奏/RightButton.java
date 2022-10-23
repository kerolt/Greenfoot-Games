import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightButton extends Button {
    
    private String pattern;
    
    // ����ѡ���ģʽ���ö���ͬ��Ч��
    public RightButton(String pattern) {
        this.pattern = pattern;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch (this.pattern) {
                case "select-music":
                    // ��ʱֻд��С����һ�����ӵ�
                    //MusicBoard.musicIdx = (MusicBoard.musicIdx + 1) % 3;
                    break;
                case "select-block":
                    BlockBoard.blockIdx = (BlockBoard.blockIdx + 1) % 2;
                    break;
                case "select-background":
                    ImageBoard.imgIdx = (ImageBoard.imgIdx + 1) % 4;
                    break;
            }
        }        
    }
}
