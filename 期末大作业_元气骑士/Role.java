import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * 玩家控制的角色
 */
public class Role extends ScrollingActor {
    
    public static int MAX_HP = 10;
    public static int MAX_MP = 300;
    public static int MAX_ARMOR = 5;
    public static int HP;
    public static int MP;
    public static int armor;
    public static MouseInfo mouseInfo;
    
    private GifImage gif;
    public boolean isStart;
    private int armorDelay;
    private int mpDelay;
    private Weapon weapon; // 当前手中的武器
    private Deque<Weapon> weaponQueue;
    
    public Role() {
        gif = new GifImage("role/1.gif");
        this.isStart = false;
        this.HP = 10;
        this.MP = 300;
        this.armor = 5;
        this.armorDelay = 0;
        this.mpDelay = 0;
        this.weaponQueue = new LinkedList<>();
    }
    
    public void act() {
        setImage(gif.getCurrentImage());
        
        // 用于确保角色进入游戏世界时至少有一把武器
        if (!this.isStart) {
            if (getWorld() instanceof Level1) {
                this.weapon = new CommonGun("普通机枪", true);
            }
            this.weaponQueue.addLast(this.weapon);
            getWorld().addObject(this.weapon, 0, 0);
            getWorld().addObject(new RolePanel(), 48, 25);
            this.isStart = true;
        }
        
        roleMove();
        // attack();
        autoRecoverMP();
        autoRecoverArmor();
        selectWeapon();
        switchWeapon();
        usePotion();
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
        /*
         * 我们有一个保存两把武器的一个双端队列，队头元素即为当前角色使用的武器
         * 当我们需要切换武器时，如下：
         */
        if (Greenfoot.isKeyDown("K") && this.weaponQueue.size() >= 2) {    
            // 1. 将队头元素出队，将其状态更改为“未被拾取”，并且为了不在场景中显示，将其从世界类中移除
            Weapon temp = this.weaponQueue.removeFirst();
            temp.isCatch = false;
            getWorld().removeObject(temp);
            
            // 2. 现在队列中只有一个元素，其即为我们切换之后的所要持有武器，将其状态置为“拾取”，并将其添加至游戏场景中
            Weapon first = this.weaponQueue.getFirst();
            first.isCatch = true;
            this.weapon = first;
            getWorld().addObject(first, getX() + 12, getY() + 7);
            
            // 3. 将第一步中出队的武器从队尾插入
            this.weaponQueue.addLast(temp);
            // System.out.println("现在的队头是：" + this.weaponQueue.getFirst().weaponName);
            
            // 播放切枪music
            Music.playMusic("switch.wav", 60);
        }
    }
    
    // 选择武器
    public void selectWeapon() {
        if (Greenfoot.isKeyDown("L") && getObjectsInRange(25, Weapon.class).size() > 1) {
            List<Weapon> weaponList = getObjectsInRange(25, Weapon.class);
            if (weaponList.size() >= 2) { // 由于角色自身自带一把武器，所以应该数量大于等于2
                for (Weapon weapon : weaponList) {
                    // 这里会有一点小bug，因为当我们按下一个键的时候，可能触发了多次这个方法
                    // 这时手上的武器的isCatch值可能已经为false了，在遍历的时候又选中了它，这就导致可能我们按了L键但是手上的武器没有与地上的武器切换
                    if (!weapon.isCatch) {
                        weapon.isCatch = true;
                        
                        if (this.weaponQueue.size() < 2) { // 若当前角色的武器队列小于2，说明还有一个武器槽
                            this.weaponQueue.add(weapon);
                            getWorld().removeObject(weapon);
                            return;
                        }
                        
                        this.weapon.isCatch = false; // 换下当前武器
                        this.weaponQueue.removeFirst(); // 将武器队列中的队头（即当前武器）删除
                        this.weaponQueue.addFirst(weapon); // 从队头加入地上的武器
                        this.weapon = weapon; // 当前武器变为地上的那把武器
                        break;
                    }
                }
            }
        }
    }
    
    // 使用药剂
    public void usePotion() {
        
    }
    
    // 角色死亡
    public void roleDie() {
        if (this.HP <= 0) {
            if (getWorld() instanceof Level1) {
                Level1.bgm.stop();
            } else if (getWorld() instanceof Level2) {
                Level2.bgm.stop();
            } else if (getWorld() instanceof Level3) {
                Level3.bgm.stop();
            }
            
            Music.playMusic("role-die.wav", 70);
            Greenfoot.delay(50);
            Greenfoot.setWorld(new GameOverWorld(1));
        }
    }
}