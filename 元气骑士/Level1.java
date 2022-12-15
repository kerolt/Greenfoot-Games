import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This subclass is just an example. You can delete it or change the code if you want.
 * It's not necessary for the scrolling system.
 */
public class Level1 extends ScrollingWorld {
    
    public static GreenfootSound bgm = new GreenfootSound("level1-bgm.wav");
    
    public int centerX = getWidth() / 2;
    public int centerY = getHeight() / 2;
    
    public Level1() {
        super(1200, 700, 1);
        setScrollingBackground(new GreenfootImage("other/bg-black.jpg"));
        createWorld();
        // Greenfoot.start();
        showText("LEVEL 1", 150, 25);
        Level1.bgm.playLoop();  
        Level1.bgm.setVolume(20);
    }
    
    public void started() {
        Level1.bgm.playLoop();  
        Level1.bgm.setVolume(20);
    }
    
    public void stopped() {
        Level1.bgm.pause();
    }
    
    public void act() {
        showText("剩余小怪数量" + getObjects(Enemy.class).size(), 300, 25);
    }
    
    public void createWorld() {
        // 初始添加游戏角色和武器
        addObject(new Role(), getWidth() / 2, getHeight() / 2);
        addObject(new FlameGun("火焰机枪", false), getWidth() / 2, getHeight() / 2 + 200);
        addObject(new Glacier("冰川", false), getWidth() / 2 + 100, getHeight() / 2 + 200);
        addObject(new GreenRattlesnake("绿色响尾蛇", false), getWidth() / 2 - 100, getHeight() / 2 + 200);
        // addObject(new Portal(), centerX + 100, getHeight() / 2); // 测试
        //room1
        createRoom(2, 1, 1, 1, 1);
        aisleY();
        //room2
        setCenter(1, 0);
        createRoom(2, 1, 1, 2, 5);
        createEnemy(centerX, centerY, 6);
        aisleX();
        aisleY();
        //room3        
        setCenter(1, 0);
        createRoom(1, 1, 2  , 1, 1);
        addObject(new Portal(), centerX, getHeight() / 2); // 设置传送门
        //room4
        setCenter(-1, 1);
        createRoom(1, 2, 2, 1, 5);
        createEnemy(centerX, centerY, 6);
        //room5
        setCenter(-1, 0);
        createRoom(1, 2, 1, 2, 5);
        createEnemy(centerX, centerY, 6);
        aisleX();
    }
    
    public void top1() {
        for (int i = 0; i < 17; i++) {
            addObject(new Wall(0), (centerX - 8 * 40) + 40 * (i), centerY - 8 * 40);
        }
    }
    
    public void top2() {
        for (int i = 0; i < 17; i++) {
            if (i != 6 && i != 7 && i != 8 && i != 9 && i !=10) { // 留出口
                addObject(new Wall(0), (centerX - 8 * 40)+ 40 * (i), centerY - 8 * 40);
            } else {
                addObject(new Floor(0), (centerX - 8 * 40)+ 40 * (i), centerY - 8 * 40);
            }
        }
    }
    
    public void bottom1() {
        for (int i = 0; i < 17; i++) {
            addObject(new Wall(0), (centerX - 8 * 40) + 40 * (i), centerY + 8 * 40);
        }
    }
    
    public void bottom2() {
        for (int i = 0; i < 17; i++) {
            if (i != 5 && i != 6 && i != 7 && i != 8 && i != 9 && i !=10 && i != 11) { // 留出口
                addObject(new Wall(0), (centerX - 8 * 40)+ 40 * (i), centerY + 8 * 40);
            } else {
                addObject(new Floor(0), (centerX - 8 * 40)+ 40 * (i), centerY + 8 * 40);
            }
        }
    }
    
    public void left1() {
        for (int i = 0; i < 17; i++) {
            addObject(new Wall(0), centerX - 8 * 40, (centerY - 8 * 40)+ 40 * (i));
        }
    }
    
    public void left2() {
        for (int i = 0; i < 16; i++) {
            if (i != 5 && i != 6 && i != 7 && i != 8 && i != 9) { // 留出口
                addObject(new Wall(0), centerX - 8 * 40, (centerY - 8 * 40) + 40 * (i + 1));
            } else {
                addObject(new Floor(0), centerX - 8 * 40, (centerY - 8 * 40) + 40 * (i + 1));
            }
        }
    }
    
    public void right1() {
        for (int i = 0; i < 16; i++) {
            addObject(new Wall(0), centerX + 8 * 40, (centerY - 8 * 40) + 40 * (i + 1));
        }
    }
    
    public void right2() {
        for (int i = 0; i < 16; i++) {
            if (i != 5 && i != 6 && i != 7 && i != 8 && i != 9) { // 留出口
                addObject(new Wall(0), centerX + 8 * 40, (centerY - 8 * 40) + 40 * (i + 1));
            } else {
                addObject(new Floor(0), centerX + 8 * 40, (centerY - 8 * 40) + 40 * (i + 1));
            }
        }
    }
    
    public void createEnemy(int centerX, int centerY, int enemyNum) {
        for (int i = 0; i < enemyNum; i++) {
            int randomX = centerX + -250 + Greenfoot.getRandomNumber(500);
            int randomY = centerY + -250 + Greenfoot.getRandomNumber(500);
            int type = Greenfoot.getRandomNumber(2);
            Enemy enemy = null;
            if (type == 0) {
                enemy = new Goblin();
            } else if (type == 1) {
                enemy = new BigGoblin();
            }
            addObject(enemy, randomX, randomY);
            if (enemy.isTouchWall()) {
                removeObject(enemy);
                i--;
            }
        }
    }

    public void aisleX(){
        for(int i = 0; i < 10; i++){
            addObject(new Wall(0), centerX + 8 * 40 + 40 * (i + 1), (centerY - 8 * 40) + 40 * 5);
            addObject(new Wall(0), centerX + 8 * 40 + 40 * (i + 1), (centerY - 8 * 40) + 40 * 11);
            for (int j = 5; j <= 10; j++) {
                addObject(new Floor(0), centerX + 8 * 40 + 40 * (i + 1), (centerY - 8 * 40) + 40 * j);
            }
        }    
    }
    
    public void aisleY(){
        for(int i = 0; i < 12; i++){
            addObject(new Wall(0), centerX - 8 * 40 + 40 * 5, (centerY - 8 * 40 - 12* 40) + 40 * (i + 1));
            addObject(new Wall(0), centerX - 8 * 40 + 40 * 11, (centerY - 8 * 40 - 12 * 40) + 40 * (i + 1));
            for (int j = 5; j <= 10; j++) {
                addObject(new Floor(0), centerX - 8 * 40 + 40 * j, (centerY - 8 * 40) - 40 * (i+1));
            }
        }
    }
    
    public void roomFloor(int x){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                addObject(new Floor(0), (centerX - 8 * 40) + 40 * (j), centerY - 8 * 40 + 40 * (i + 1));   
            }
        }
        switch(x){
            //十字
            case 1:{
                for(int i = 1; i <= 9; i++){
                    addObject(new Wall(0), centerX - 5 * 40 + i * 40, centerY);
                    addObject(new Wall(0), centerX, centerY - 5 * 40 + i * 40);
                }
            }
            break;
            //二横
            case 2:{
                for(int i = 1; i <= 9; i++){
                    addObject(new Wall(0), centerX - 5 * 40 + i * 40,centerY - 3 * 40);
                    addObject(new Wall(0), centerX - 5 * 40 + i * 40,centerY + 3 * 40);
                }
            }
            break;
            //二竖
            case 3:{
                for(int i = 1; i <= 9; i++){
                    addObject(new Wall(0), centerX - 3 * 40,centerY - 5 * 40 + i * 40);
                    addObject(new Wall(0), centerX + 3 * 40,centerY - 5 * 40 + i * 40);
                }
            }
            break;
            //方形
            case 4:{
                for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    addObject(new Wall(0), (centerX - 3 * 40) + 40 * (j), centerY - 4 * 40 + 40 * (i + 1));   
                }
            }
            }
            break;
            //四角
            case 5:{
                    for (int i = 1; i <= 9; i++) {
                        if(i == 1 || i == 2 || i ==3 || i == 7 || i == 8 || i ==9){
                            addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY - 4 * 40);
                            addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY + 4 * 40);
                            if(i == 1 || i == 9){
                                addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY - 4 * 40 + 40);
                                addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY - 4 * 40 + 80);
                                addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY + 4 * 40 - 80);
                                addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY + 4 * 40 - 40);
                                addObject(new Wall(0), (centerX - 5 * 40) + i *40, centerY + 4 * 40);
                            }
                        }
                    }
            }
            break;
        }
        
    }
    
    public void createRoom(int t, int b, int l, int r,int x){
        if (t==1) {
            top1();
        } else {
            top2();
        }
        if (b == 1) {
            bottom1();
        } else {
            bottom2();
        }
        if (l == 1) {
            left1();
        } else{
            left2(); 
        }
        if (r == 1) {
            right1();
        } else {
            right2();
        }
        if(x == 1)roomFloor(0);
        else {
            x=Greenfoot.getRandomNumber(x) + 1;
            roomFloor(x);
        }
    }
    
    public void setCenter(int x,int y){
        if (x == 1){
            centerX = centerX + 8 * 40 + 40 * 11 + 8 * 40;
        }
        if (x == -1){
            centerX = centerX - 8 * 40 - 40 * 11 - 8 * 40;
        }
        if (y == 1){
            centerY = centerY - 8 * 40 - 11 * 40 - 8 * 40;
        }
        if (y == -1){
            centerY = centerY + 8 * 40 + 11 * 40 + 8 * 40;
        }
    }
    
    
}