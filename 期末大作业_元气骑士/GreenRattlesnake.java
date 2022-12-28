import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 武器-绿色响尾蛇
 */
public class GreenRattlesnake extends Weapon {
    
    public boolean isCatch; // 是否被拿起
    private static int shootBufferTime = 40; // 射击缓冲时间
    private static int blueConsumption = 5; // 蓝耗
    private static int attack = 7; // 武器的攻击力
    private static String weaponName = "绿色响尾蛇"; // 武器名
    
    public GreenRattlesnake(String weaponName, boolean isCatch) {
        super(weaponName, isCatch, shootBufferTime, blueConsumption, attack);
        this.isCatch = isCatch;
        setImage("weapon/绿色响尾蛇.png");
    }
}
