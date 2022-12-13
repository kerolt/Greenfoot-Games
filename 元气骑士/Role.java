import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * 玩家控制的角色
 */
public class Role extends ScrollingActor {
    
    public static int MAX_HP = 10;
    public static int MAX_MP = 200;
    public static int MAX_ARMOR = 5;
    public static int HP;
    public static int MP;
    public static int armor;
    
    private GifImage gif;
    private boolean isStart;
    private int armorDelay;
    private int mpDelay;
    private Weapon weapon; // 当前手中的武器
    
    public Role() {
        gif = new GifImage("role/1.gif");
        this.isStart = false;
        this.HP = 10;
        this.MP = 200;
        this.armor = 5;
        this.armorDelay = 0;
        this.mpDelay = 0;
    }
    
    /**
     * Here you can tell your actor what he has to do.
     */
    public void act() {
        setImage(gif.getCurrentImage());
        
        // 用于确保角色进入游戏世界时至少有一把武器
        if (!this.isStart) {
            Weapon weapon = new CommonGun("普通机枪", true);
            this.weapon = weapon;
            getWorld().addObject(weapon, 0, 0);
            getWorld().addObject(new RolePanel(), 48, 25);
            this.isStart = true;
        }
        
        roleMove();
        // attack();
        autoRecoverMP();
        autoRecoverArmor();
        switchWeapon();
        roleDie();
    }
    
    public void roleMove() {
        // 确保在当前方向上碰到障碍物后不会继续移动
        if (Greenfoot.isKeyDown("w") && getOneObjectAtOffset(0, -1 * getImage().getHeight() / 2, Wall.class) == null) {
            setLocation(getX(), getY() - 6);
        }
        if (Greenfoot.isKeyDown("s") && getOneObjectAtOffset(0, 1 * getImage().getHeight() / 2, Wall.class) == null) {
            setLocation(getX(), getY() + 6);
        }
        if (Greenfoot.isKeyDown("a") && getOneObjectAtOffset(-1 * getImage().getWidth() / 2, 0, Wall.class) == null) {
            setLocation(getX() - 6, getY());
        }
        if (Greenfoot.isKeyDown("d") && getOneObjectAtOffset(1 * getImage().getWidth() / 2, 0, Wall.class) == null) {
            setLocation(getX() + 6, getY());
        }
    }
    
    // 自动回蓝
    public void autoRecoverMP() {
        if (Role.MP < Role.MAX_MP) {
            if (this.mpDelay >= 200) {
                this.MP = this.MP + 5 > this.MAX_MP ? this.MAX_MP : this.MP + 5;
                this.mpDelay = 0;
            }
            this.mpDelay++;
        }
    }
    
    public void autoRecoverArmor() {
        if (Role.armor < Role.MAX_ARMOR) {
            if (this.armorDelay >= 200) {
                this.armor = this.armor + 1 > this.MAX_ARMOR ? this.MAX_ARMOR : this.armor + 1;
                this.armorDelay = 0;
            }
            this.armorDelay++;
        }
    }
    
    // 切换武器
    public void switchWeapon() {
        if (Greenfoot.isKeyDown("L") && getObjectsInRange(25, Weapon.class).size() > 1) {
            List<Weapon> weaponList = getObjectsInRange(25, Weapon.class);
            if (weaponList.size() >= 2) { // 由于角色自身自带一把武器，所以应该数量大于等于2
                for (Weapon weapon : weaponList) {
                    // 这里会有一点小bug，因为当我们按下一个键的时候，可能触发了多次这个方法
                    // 这时手上的武器的isCatch值可能已经为false了，在遍历的时候又选中了它，这就导致可能我们按了L键但是手上的武器没有与地上的武器切换
                    if (!weapon.isCatch) {
                        weapon.isCatch = true;
                        this.weapon.isCatch = false;
                        this.weapon = weapon;
                        break;
                    }
                }
            }
        }
    }
    
    // 角色死亡
    public void roleDie() {
        if (this.HP <= 0) {
            Greenfoot.delay(50);
            Greenfoot.setWorld(new GameOverWorld());
        }
    }
}