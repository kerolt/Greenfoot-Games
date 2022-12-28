import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 螃蟹血量类
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP extends Show {
    
    GreenfootImage scoreImg; // 生命值显示
    
    public HP() {
        scoreImg = new GreenfootImage(300, 40);
        // int hp = getWorld().getObjects(Crab.class).get(0).hp;
        setHp(5);
    }
    
    public void setHp(int score) {
        scoreImg.clear();
        Font f = new Font("Comic Sans MS", true, false,  30);
        scoreImg.setFont(f);
        scoreImg.drawImage(new GreenfootImage("hp.png"), 30, 5);
        scoreImg.drawString(": " + score, 60, 30);
        setImage(scoreImg);
    }
}
