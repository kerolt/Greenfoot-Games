import greenfoot.*;

/**
 * 游戏开始对象，用作游戏开始按钮
 */
public class Start extends GUI{
    public void act() {   
        if ((Greenfoot.mouseClicked(this))){  //鼠标点击，游戏开始
            Sky.isPaused = false;
            getWorld().removeObjects(getWorld().getObjects(GUI.class));
            Greenfoot.playSound("start.mp3");
        }
    }
}
