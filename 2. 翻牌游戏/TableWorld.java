import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * 牌桌类，提供游戏的运行场景
 */
public class TableWorld extends World{
    ArrayList<Card> cards = new ArrayList<Card>();  //声明一个保存扑克牌对象的集合cards 
    public static int diff;
    private boolean run = false;
    private int nums; // 牌的数量
    
    public void started() {
        Time.startTime = System.currentTimeMillis();   
    }
    
    public void stopped() {
        Time.tempTime = Time.playTime;
    }
    
    //Table类的构造方法
public TableWorld() {   
    super(600, 400, 1);
    addObject(new Time(), 520, 50);
    addObject(new Counter(), 420, 50);
    switch (this.diff) {
        case 0: this.nums = 5; break;
        case 1: this.nums = 7; setBackground("medium.jpg"); break;
        case 2: this.nums = 10; setBackground("hard.jpg"); break;
    }
    for (int i = 1; i <= this.nums; i++) {
        cards.add(this.nums != 10 ? new Card("hearts", i) : new Card("fruit", i));
        cards.add(this.nums != 10 ? new Card("hearts", i) : new Card("fruit", i));
    }
    Collections.shuffle(cards); //集合类Collections的混排算法，用于打乱集合cards中牌的顺序
}
    
    //act()方法是游戏单步执行的动作
    public void act() {
        // 添加一点动画效果
        if (!run) {
            int x = this.diff == 0 ? 100 : 50;
            int y = 100;   //牌桌上摆放牌的起点坐标
            int offset = this.diff == 0 ? 20 : 10;
            if (this.nums == 5 || this.nums == 7) {
                for (int i = 0; i < this.nums; i++) {
                    addObject(cards.get(i) , x, y);
                    Greenfoot.delay(5);
                    addObject(cards.get(i + this.nums), x, y + cards.get(i).getImage().getHeight() + 20);
                    Greenfoot.delay(5);
                    x += cards.get(i).getImage().getWidth() + offset;
                    run = true;
                }
            } else {
                int i;
                for (i = 0; i < 7; i++) {
                    addObject(cards.get(i) , x, y);
                    Greenfoot.delay(5);
                    addObject(cards.get(i + 7), x, y + cards.get(i).getImage().getHeight() + 20);
                    Greenfoot.delay(5);
                    x += cards.get(i).getImage().getWidth() + offset;
                    run = true;
                }
                i = 14;
                x = 80;
                while (i < 20) {
                    addObject(cards.get(i), x, y + cards.get(i).getImage().getHeight() * 2 + 40);
                    x += cards.get(i).getImage().getWidth() + offset;
                    i++;
                    Greenfoot.delay(5);
                }
            }
        }
        int count = 0, card1Value=0, card2Value=0;    //count表示牌桌上被翻开的第几张牌
        Card card1=null, card2=null;
        for (int i=0; i< cards.size(); i++) {    //用for循环遍历集合cards中的所有牌
            if (cards.get(i).getFaceup() == true) {    //如果遍历到的这张牌是翻开的
                count++;        //用count将牌桌上翻开的牌数累加
                if (count == 1) {            //如果是第一张翻开的牌
                    card1 = cards.get(i);    
                    card1Value = card1.getValue();    //变量card1Value记录第一张翻开牌的点数
                }
                if (count == 2) {            //如果是第二张翻开的牌
                    card2 = cards.get(i);
                    card2Value = card2.getValue();    //变量card2Value记录第二张翻开牌的点数
                    if (card1Value == card2Value) {   // 如果翻开的两张牌的点数是一样的 
                        Greenfoot.playSound("WaterDrop.wav");
                        Greenfoot.delay(5);    //延迟10毫秒，游戏效果更好
                        //移除翻开的两张同样的牌
                        removeObject(card1);
                        removeObject(card2);
                        cards.remove(card1);
                        cards.remove(card2);
                        if (cards.size() == 0) {    //配对的牌全部找到，游戏结束
                            addObject(new ScoreBoard(), getWidth() / 2, getHeight() / 2);
                            Greenfoot.stop();
                        }
                    }
                    else {    //如果翻开的两张牌不同
                        Greenfoot.delay(15);
                        // 将两张牌面朝下背朝上
                        card1.turnFaceDown();
                        card2.turnFaceDown();
                    }
                    break;    //两张牌如相同，则移除，如不同，则翻回来。剩下的牌不再遍历，结束for循环
                }
            }
        }
    }
    
    
}
