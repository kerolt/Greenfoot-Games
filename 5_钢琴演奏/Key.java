import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * 琴键类，用来表示钢琴的琴键
 */
public class Key extends Actor{
    private  boolean  isDown;   //记录琴键对象是否被按下的标记变量
    private String key;         //对象成员变量key表示电脑按键的键名
    private String sound;       //对象成员变量sound表示琴键对应的声音文件
    private String upImage;     //琴键弹起的效果图片名
    private String downImage;   //琴键按下的效果图片名

    //Key类的构造器方法重载
    public Key(String keyName, String soundFile, String img1, String img2){
        sound = soundFile;
        key = keyName;
        upImage = img1;
        downImage = img2;
        setImage(upImage);
        isDown = false;  
        getImage().setTransparency(220);
    }

    /**
     * 鼠标点击和键盘敲击时，
     * 都会有：琴键样式变化、生成彩色块、发出声音
     */
    public void act(){
        if( !isDown && (Greenfoot.isKeyDown(key) || Greenfoot.mouseClicked(this))){
            //GreenfootSound gfs = new GreenfootSound(sound);
            //gfs.setVolume(30);
            Greenfoot.playSound(sound);
            //gfs.play();
            setImage(downImage);
            getImage().setTransparency(220);
            isDown=true;
            
            // 以下用来显示琴键点击或按下时的特效
            PianoWorld w = (PianoWorld)getWorld();
            int x = getX();
            int y = getY();
            w.addObject(new ColorBlock(x, y - 100), x, y - 100);
        }
        if(isDown && (!Greenfoot.isKeyDown(key) && !Greenfoot.mouseClicked(this))){
            setImage(upImage);
            getImage().setTransparency(220);
            isDown=false;
        }
    }
    
    // 播放按键对应音乐 --- >自动播放使用
    public void autoPlay() {
        if(!isDown) {
           // System.out.println(key);
            Greenfoot.playSound(sound);
            setImage(downImage);
            getImage().setTransparency(220);
            isDown=true;  
        }
        Greenfoot.delay(2);
        if(isDown) {
            setImage(upImage);
            getImage().setTransparency(220);
            isDown = false;
        }
    }
    
}