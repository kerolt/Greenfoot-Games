import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImageFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageFrame extends Actor {
    
    private String imgName;
    
    public ImageFrame(String imgName) {
        this.imgName = imgName;
        this.setImage(imgName + ".jpg");
    }
}
