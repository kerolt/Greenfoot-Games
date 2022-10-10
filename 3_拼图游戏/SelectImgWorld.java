import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectImgWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectImgWorld extends World {
    
    private int x, y;
    public static String difficulty;
    
    public SelectImgWorld() {  
        super(600, 405, 1);
        // this.difficulty = "";
        x = 85;
        y = 140;
        
        for (int i = 0; i < 4; i++) {
            addObject(new ImageFrame("select" + i), x, y);
            x += 145;
        }
        
        x = 50;
        y = 250;
        
        for (int i = 0; i < 4; i++) {
            addObject(new EasyButton("select" + i), x, y);
            addObject(new HardButton("select" + i), x + 70, y);
            x += 145;
        }
        
        addObject(new ReturnButton(), 40, 360);
        
    }
}
