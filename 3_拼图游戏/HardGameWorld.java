import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class HardGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardGameWorld extends World {
    private ArrayList<Pic> pics = new ArrayList<Pic>();  //图片对象列表
    private Pic lastPic;  //最后一张图片
    private boolean run;  //游戏状态标识
    public static String imgName;
    
    public void started() {
        Time.startTime = System.currentTimeMillis();   
    }
    
    public void stopped() {
        Time.tempTime = Time.playTime;
    }

    //构造方法，初始化游戏场景
    public HardGameWorld(String imgName) {    
        super(10, 5, 81);
        this.imgName = imgName;
        addObject(new Counter(), 7, 0);
        addObject(new Time(), 7, 0);
        for (int i=0; i < 24; i++) {   //建立25个图片对象，并添加至游戏场景中
            Pic pic = new Pic(imgName, i, "hard_");
            pics.add(pic);
            addObject(pic, i % 5, i / 5);
        }
        lastPic = new Pic(imgName, 24, "hard_");     //创建最后一个图片对象，并加入游戏场景
        addObject(lastPic, 4, 4);
        run = false;
        addObject(new InfoArea(), 7, 2);
        // addObject(new ScoreBoard(), 7, 3);
    }
    
    
    
    //重置图片，打乱图片的显示顺序
    public void resetPics(){
        for (int i=0; i<24; i++) {  //将图片从游戏场景移除
            removeObject(pics.get(i));
            Greenfoot.delay(3);
        }
        removeObject(lastPic);
        Greenfoot.delay(10);
        Collections.shuffle(pics);  //随机打乱图片列表中的图片位置
        
        // 让游戏变得有解
        int cnt = 0;
        while (true) {
            cnt = 0;
            for (int i = 0; i < pics.size(); i++)
                for (int j = i + 1; j < pics.size(); j++)
                    if (pics.get(i).value > pics.get(j).value) cnt++;
            if (cnt % 2 == 0) break;
            Collections.shuffle(pics);
        }
        
        for (int i=0; i<24; i++) {   //将打乱后图片重新加入游戏场景
            addObject(pics.get(i), i%5, i/5);
        }
        run=true;  //将游戏状态标识为运行
    }
    
    //更新游戏世界的运行逻辑
    public void act() {
        if (!run) {  //若游戏尚未运行，则重置图片
            resetPics();
        }
        if (Time.isOver) {
            addObject(lastPic, 4, 4);  //加入最后一张图片
            Greenfoot.playSound("win.wav"); //播放完成的音效
            addObject(new ScoreBoard(), 7, 3);
            Greenfoot.stop();          //停止游戏
        }
        for (int i=0; i<24; i++) {  //判断拼图是否完成
            List<Pic> pictures = getObjectsAt(i%5, i/5, Pic.class);
            if (pictures.size()==0 || pictures.get(0).getValue()!=i) return;
        }
        addObject(lastPic, 4, 4);  //加入最后一张图片
        Greenfoot.playSound("win.wav"); //播放完成的音效
        Greenfoot.stop();          //停止游戏
    }
}
