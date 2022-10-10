import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class Tips here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tips extends UI {
    public Tips() {
        JFrame jf = new JFrame("Tips");
        jf.setBounds(450, 300, 600, 400);
        
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();
        
        String tips = "<html><body style='font-family: \"楷体\"'>" +
                        "<h1>游戏介绍:</h1>" +
                        "<span style='color: green'>游戏中使用鼠标点击任意两张牌，若相同则可翻开~</span>" +
                        "<br>" +
                        "考验你的记忆力，力争用最短的时间翻开所有的牌吧!" + 
                        "<body></html>";
        jl.setFont(new java.awt.Font("Ink Free", java.awt.Font.PLAIN, 24));
        jl.setText(tips);
        jl.setHorizontalAlignment(SwingConstants.CENTER);

        jp.setLayout(new BorderLayout());
        jp.add(jl);
        jf.add(jp);
        
        jf.setVisible(true);
    }
}