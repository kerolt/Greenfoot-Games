import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftButton extends Button {
    
    private String pattern;
    
    // 根据选择的模式来置顶不同的效果
    public LeftButton(String pattern) {
        this.pattern = pattern;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch (this.pattern) {
                case "select-music":
                    // 暂时只写了小星星一首曲子的
                    // MusicBoard.musicIdx = (MusicBoard.musicIdx - 1 + 3) % 3;
                    break;
                case "select-block":
                    // 减去1再加上2是为了确保不会发生溢出问题
                    BlockBoard.blockIdx = (BlockBoard.blockIdx - 1 + 2) % 2;
                    break;
                case "select-background":
                    ImageBoard.imgIdx = (ImageBoard.imgIdx - 1 + 4) % 4;
                    break;
            }
        }
    }
}
