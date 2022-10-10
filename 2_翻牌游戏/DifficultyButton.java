import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 难度按钮类
 */
public class DifficultyButton extends Button {
    GreenfootImage diffImage;
    String difficulty;
    int speed = 10;
    int time = 100;
    int endTime;
    
    /**
     * 根据形参名设置难度图片
     */
    public DifficultyButton(String difficulty) {
        this.difficulty = difficulty;
        diffImage = new GreenfootImage("Button" + difficulty + ".png");
        setImage(diffImage);
    }
    
    public void act() {
        arrival();
        checkClick();
    }
    
    /**
     * 一点小小的动画效果
     */
    public void arrival() {
        if(getY() < getWorld().getHeight() / 2 && endTime < 20)
            setLocation(getX(), getY() + speed);
        else if(endTime < 20) {
            endTime++;
            if(time % 20 == 0) {
                speed--;
                setLocation(getX(), getY() + speed);
            }
        }
    }
    
    /**
     * 为按钮绑定点击事件，并设置难度系数
     */
    public void checkClick() {
        if(Greenfoot.mouseClicked(this)) {
            switch(difficulty) {
                case "Hard" : TableWorld.diff = 2;
                    break;
                case "Medium" : TableWorld.diff = 1;
                    break;
                case "Easy" : TableWorld.diff = 0;
                    break;
            }
            Greenfoot.setWorld(new TableWorld());
            Time.startTime = System.currentTimeMillis();
        }
    }
}
