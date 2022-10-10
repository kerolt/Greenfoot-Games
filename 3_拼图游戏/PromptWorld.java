import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
/**
 * Write a description of class PromptWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PromptWorld extends World{
    
    public PromptWorld() {    
        super(600, 400, 1); 
        
        addObject(new Actor() { {
            GreenfootImage text = new GreenfootImage("游戏提示\n本游戏已进行优化,\n所有拼图均不会出现死局的情况", 40, null, null);
            text.setFont(new Font("Ink Free", false, false, 20));
            setImage(text);
        };}, 300, 200);
        
        addObject(new ReturnButton(), 40, 360);
    }
}
