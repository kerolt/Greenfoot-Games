import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 角色属性条
 */
public class Strip extends FixedObject {
    
    private String type;
    private GreenfootImage stripImage = new GreenfootImage(100, 20);
    
    public Strip(String type) {
        this.type = type;
        if (this.type == "HP") {
            stripImage.setColor(Color.RED);
            stripImage.fillRect(0, 0, (int)((double)Role.HP / Role.MAX_HP * 75),10);
        } else if (this.type == "armor") {
            stripImage.setColor(Color.GRAY);
            stripImage.fillRect(0, 0, (int)((double)Role.armor / Role.MAX_ARMOR * 75),10);
        } else if (this.type == "MP") {
            stripImage.setColor(Color.BLUE);
            stripImage.fillRect(0, 0, (int)((double)Role.MP / Role.MAX_MP * 75),10);
        }
        setImage(stripImage);
    }
}
