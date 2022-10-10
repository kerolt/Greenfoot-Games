import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InfoArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoArea extends Actor {
    
    private String imgName;
    private GreenfootImage showArea;
    
    /**
     * 创建总的画布，同时画出边界
     */
    public InfoArea() {
        this.imgName = SelectImgWorld.difficulty == "easy" ? EasyGameWorld.imgName : HardGameWorld.imgName;        
        showArea = new GreenfootImage(405, 405);
        showArea.setColor(Color.GRAY);
        showArea.fillRect(0, 0, 400, 10);
        showArea.fillRect(0, 395, 400, 10);
        showArea.fillRect(0, 0, 10, 405);
        showArea.fillRect(395, 0, 10, 405);
        setImage(showArea);
        showImg();
    }
    
    /**
     * 添加相应的文字信息
     */
    public void showImg() {
        GreenfootImage img = new GreenfootImage(this.imgName + ".jpg");
        GreenfootImage text = new GreenfootImage("原图：", 30, null, null);
        GreenfootImage tips = new GreenfootImage("使用最短时间和步数\n来赢得胜利吧！", 40, null, null);
        img.scale(120, 120);
        showArea.drawImage(text, 20, 60);
        showArea.drawImage(img, 85, 20);
        showArea.drawImage(tips, 70, 220);
    }
}
