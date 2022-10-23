import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftButton extends Button {
    
    private String pattern;
    
    // ����ѡ���ģʽ���ö���ͬ��Ч��
    public LeftButton(String pattern) {
        this.pattern = pattern;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch (this.pattern) {
                case "select-music":
                    // ��ʱֻд��С����һ�����ӵ�
                    // MusicBoard.musicIdx = (MusicBoard.musicIdx - 1 + 3) % 3;
                    break;
                case "select-block":
                    // ��ȥ1�ټ���2��Ϊ��ȷ�����ᷢ���������
                    BlockBoard.blockIdx = (BlockBoard.blockIdx - 1 + 2) % 2;
                    break;
                case "select-background":
                    ImageBoard.imgIdx = (ImageBoard.imgIdx - 1 + 4) % 4;
                    break;
            }
        }
    }
}
