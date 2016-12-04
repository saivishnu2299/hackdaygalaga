import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * Space. Something for rockets to fly in...
 * 
 * @author SQUAD
 */
public class Space extends World
{
    public Space() 
    {
        super(600, 550, 1);
        setBackground("GGBG.gif");
        
       
        createStars(300);
        Explosion.initialiseImages();
        addObject(new Rocket(), 275, 470);
        addObject(new Asteroid(), 60, 70);
        addObject(new Asteroid(), 120, 70);
        addObject(new Asteroid(), 180, 70);
        addObject(new Asteroid(), 240, 70);
        addObject(new Asteroid(), 300, 70);
        addObject(new Asteroid(), 360, 70);
        addObject(new Asteroid(), 420, 70);
        addObject(new Asteroid(), 480, 70);
        addObject(new Asteroid(), 540, 70);
        
        
        
        
        
    }
   
    
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for(int i=0; i < number; i++) {            
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x,y,new Color(color,color,color));
             
        }
    }
}
