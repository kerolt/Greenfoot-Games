import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagicPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicPotion extends GameProps {
    
    public MagicPotion() {
        setImage("other/mp.png");
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("O") && isTouching(Role.class)) {
            Music.playMusic("potion.wav", 70);
            Role.MP = Role.MP + 50 > Role.MAX_MP ? Role.MAX_MP : Role.MP + 50;
            getWorld().removeObject(this);
        }
    }
}
