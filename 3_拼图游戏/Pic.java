import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * 图片类，用来表示组成完整拼图的每个图片
 */
public class Pic extends Actor{
    
    public int value; //图片的索引值
    private int offset;
    
    //构造方法，设置图片索引值和相关图像
    public Pic(String imgName, int value, String diff) {
        this.value = value;
        if (SelectImgWorld.difficulty == "easy") {
            setImage("split\\" + imgName + "_" + diff + value + ".jpg");
            this.offset = 2;
        } else {
            setImage("split\\" + imgName + "_" + diff + value + ".jpg");
            this.offset = 4;
        }
        
    }
    
    //获取图片索引值
    public int getValue() {
        return value;    
    }
    
    //更新图片对象的运行逻辑
    public void act() {       
        if (Greenfoot.mouseClicked(this)) {  //若鼠标点击图片，则检查其四围是否可以移动  
            Counter.count++;
            //检查上方是否可移动
            if (getY()>0 && checkPic(getX(), getY()-1)) {  
                setLocation(getX(), getY()-1);
                return;
            }       
            //检查下方是否可移动
            if (getY()<this.offset && checkPic(getX(), getY()+1)) {  
                setLocation(getX(), getY()+1);
                return;
            }       
            //检查左方是否可移动
            if (getX()>0 && checkPic(getX()-1, getY())) {  
                setLocation(getX()-1, getY());
                return;
            }
            //检查右方是否可移动
            if (getX()<this.offset && checkPic(getX()+1, getY())) { 
                setLocation(getX()+1, getY());
                return;
            }
        }
    }    
    
    
    //检查某个方格是否有图片
    private boolean checkPic(int x, int y) {
        List<Pic> pics = getWorld().getObjectsAt(x, y, Pic.class);
        if (pics.size()>0) {
            return false;
        } else {
            return true;
        }
    }
}
