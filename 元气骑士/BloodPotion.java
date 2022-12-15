import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 生命药剂
 */
public class BloodPotion extends GameProps {
    
    public BloodPotion() {
        setImage("other/hp.png");
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("O") && isTouching(Role.class)) {
            Music.playMusic("potion.wav", 70);
            Role.HP = Role.HP + 2 > Role.MAX_HP ? Role.MAX_HP : Role.HP + 2;
            getWorld().removeObject(this);
        }
    }
}
