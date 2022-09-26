import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifficultyMenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyMenuWorld extends World
{
    int time;
    public DifficultyMenuWorld() {
        super(600, 400, 1);
    }
    
    public void act() {
        time++;
        if(time == 1)
            addObject(new DifficultyButton("Easy"), 155, 00);
        else if(time == 21)
            addObject(new DifficultyButton("Medium"), 320, 00);
        else if(time == 41)
            addObject(new DifficultyButton("Hard"), 475, 00);
    }
}
