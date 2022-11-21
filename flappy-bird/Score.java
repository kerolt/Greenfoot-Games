import greenfoot.*;

/**
 * 计分对象，用来显示游戏分数
 */
public class Score extends Actor{
  GreenfootImage newImage;
  public static int score;
  
  //构造方法，初始化计分对象
  public Score(){
    newImage = new GreenfootImage(80, 120);
    this.score = 0;
    setScore(0);
  }
  
  //显示游戏分数
  public void setScore(int score){
    this.score = score;
    newImage.clear();    
    Font f = new Font("Comic Sans MS", false, false, 34);  //设置字体
    newImage.setFont(f);
    newImage.drawString("" + score, 30, 30);  //显示分数
    setImage(newImage);
  }
}
