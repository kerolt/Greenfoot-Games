import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * �ټ��࣬������ʾ���ٵ��ټ�
 */
public class Key extends Actor{
    private  boolean  isDown;   //��¼�ټ������Ƿ񱻰��µı�Ǳ���
    private String key;         //�����Ա����key��ʾ���԰����ļ���
    private String sound;       //�����Ա����sound��ʾ�ټ���Ӧ�������ļ�
    private String upImage;     //�ټ������Ч��ͼƬ��
    private String downImage;   //�ټ����µ�Ч��ͼƬ��

    //Key��Ĺ�������������
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
     * ������ͼ����û�ʱ��
     * �����У��ټ���ʽ�仯�����ɲ�ɫ�顢��������
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
            
            // ����������ʾ�ټ��������ʱ����Ч
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
    
    // ���Ű�����Ӧ���� --- >�Զ�����ʹ��
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