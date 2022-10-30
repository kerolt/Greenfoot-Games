import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 播放音乐的按钮，其中有静态属性：musicState、bgSound
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicButton extends Button {
    
    public static boolean musicState;            // 音乐状态
    public static GreenfootSound bgSound = null; // 背景音乐
    
    public MusicButton() {
        MusicButton.musicState = true;
        if (MusicButton.bgSound == null) {
            MusicButton.bgSound = new GreenfootSound("bg-sound.mp3");   
        } else {
            bgSound.playLoop();
        }
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (MusicButton.musicState) {
                setImage("off.png");
                MusicButton.bgSound.pause();
            } else {
                setImage("on.png");
                MusicButton.bgSound.playLoop();
            }
            MusicButton.musicState = !MusicButton.musicState;
        }
        
    }
}
