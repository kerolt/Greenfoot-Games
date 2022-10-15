import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CustomWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomWorld extends World {

    
    
    public CustomWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Props.rows = 15;
        Props.cols = 9;
        Props.bombs = 9;
        addObject(new ReturnButton(), 30, 30);
        addObject(new GoCustomButton(), getWidth() / 2, getHeight() / 2 + 140);
        addObject(new Actor(){{
            GreenfootImage temp = new GreenfootImage(200, 70);
            temp.setFont(new Font("微软雅黑",true, false, 27));
            temp.drawString("Rows: ", 0, 20);
            this.setImage(temp);
        }}, 230, 120);
        addObject(new Actor(){{
            GreenfootImage temp = new GreenfootImage(200, 70);
            temp.setFont(new Font("微软雅黑",true, false, 27));
            temp.drawString("Cols: ", 0, 20);
            this.setImage(temp);
        }}, 230, 190);
        addObject(new Actor(){{
            GreenfootImage temp = new GreenfootImage(200, 70);
            temp.setFont(new Font("微软雅黑",true, false, 27));
            temp.drawString("Bombs: ", 0, 20);
            this.setImage(temp);
        }}, 230, 260);
        int offset = 0;
        for (int i = 0; i < 3; i++) {
            addObject(new PlusButton(i), 280, 95 + offset);
            addObject(new MinusButton(i), 400, 95 + offset);
            offset += 70;
        }
        offset = 0;
        for (int i = 0; i < 3; i++) {
            addObject(new Props(i), 350, 95 + offset);
            offset += 70;
        }
    }
}
