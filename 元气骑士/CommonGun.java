import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CommonGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommonGun extends Weapon {
    public boolean isCatch; // 是否被拿起
    private static int shootBufferTime = 6; // 射击缓冲时间
    private static int blueConsumption = 1; // 蓝耗
    private static int attack = 1; // 武器的攻击力
    private static String weaponName = "普通机枪"; // 武器名
    
    public CommonGun(String weaponName, boolean isCatch) {
        super(weaponName, isCatch, shootBufferTime, blueConsumption, attack);
        this.isCatch = isCatch;
        setImage("weapon/普通机枪.png");
    }

}
