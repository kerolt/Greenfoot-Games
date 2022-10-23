import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 自动播放类
 */
public class MusicScore extends Actor {
    
    // 小星星曲谱
    public static final String music0 = 
    "C3|10|C3|10|G3|10|G3|10|A3|10|A3|10|G3|20|F3|10|F3|10|E3|10|E3|10|D3|10|D3|10|C3|20|G3|10|G3|10|F3|10|F3|10|E3|10|E3|10|D3|20|G3|10|G3|10|F3|10|F3|10|E3|10|E3|10|D3";
    
    public static boolean isFinish;
    
    public MusicScore() {
        this.isFinish = true;    
    }
    
    public void act() {
        if (MusicScore.isFinish && Greenfoot.mouseClicked(this)) {
            MusicScore.isFinish = false;
            this.autoPlay(this.music0);  // 暂时只写了小星星的谱子
        }
    }
    
    public void autoPlay(String music) {
        //music = music == "music0" ? this.music0 : music == "music1" ? this.music1 : this.music2;
        String[] musicKey = music.split("\\|");  // 截取乐谱中的音符
        PianoWorld world = (PianoWorld)getWorld();
        //for (String str : musicKey) {
        //    System.out.println(str);
        //}
        for (String str : musicKey) {
            Key k = world.keyMap.get(str);  // 从哈希表中根据琴音（键）去取对应的琴键（值）
            if (k != null) {
                k.autoPlay();
                // int x = k.getX();
                // int y = k.getY();
                // world.addObject(new ColorBlock(x, y - 100), x, y - 100);
            } else {
                int delayTime = Integer.parseInt(str);
                Greenfoot.delay(delayTime);
            }
            Greenfoot.delay(12);
        }
        MusicScore.isFinish = true;
    }
}
