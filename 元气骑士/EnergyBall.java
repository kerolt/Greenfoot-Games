import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnergyBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnergyBall extends GameProps {
    
    public EnergyBall() {
        setImage("other/energy.png");
    }
    
    public void act() {
        if (isTouching(Role.class)) {
            Music.playMusic("energy.wav", 70);
            Role.MP = Role.MP + 2 > Role.MAX_MP ? Role.MAX_MP : Role.MP + 2;
            getWorld().removeObject(this);
        }
    }
}
