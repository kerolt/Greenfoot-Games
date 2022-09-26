import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Show
{
    GreenfootImage scoreImg; // 游戏分数显示
    
    public Score() {
        scoreImg = new GreenfootImage(300, 40);
        setScore(0);
    }
    
    public void setScore(int score) {
        scoreImg.clear();
        Font f = new Font("Comic Sans MS", true, false,  30);
        scoreImg.setFont(f);
        scoreImg.drawString("Score: " + score, 30, 30);
        setImage(scoreImg);
    }
}
