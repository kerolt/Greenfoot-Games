import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tip extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 390;
    public static final int HEIGHT = 160;
    GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
    
    public Tip(String title)
    { 
        makeImage(title);
    }
    
    public void makeImage(String title)
    {
        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        setImage(image);
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown ("space"))
        {
            image.clear(); 
        }
    }
}
