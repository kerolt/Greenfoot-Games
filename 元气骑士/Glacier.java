import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 武器-冰川
 */
public class Glacier extends Weapon {
    
    public boolean isCatch; // 是否被拿起
    private static int shootBufferTime = 20; // 射击缓冲时间
    private static int blueConsumption = 3; // 蓝耗
    private static int attack = 5; // 武器的攻击力
    private static String weaponName = "冰川"; // 武器名
    
    public Glacier(String weaponName, boolean isCatch) {
        super(weaponName, isCatch, shootBufferTime, blueConsumption, attack);
        this.isCatch = isCatch;
        setImage("weapon/冰川.png");
    }
}
