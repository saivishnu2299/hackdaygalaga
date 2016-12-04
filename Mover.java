import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A thing that can move around with a certain speed.
 * 
 * @author Poul Henriksen
 */
public abstract class Mover extends Actor
{
    private Vector movement = new Vector();
    
    private double x = 0;
    public double y = 0;
    
    public Mover()
    {
    }
    
    /**
     * Create new thing initialised with given speed.
     */
    public Mover(Vector speed)
    {
        movement = speed;

    }
    /**
     * Move forward one step.
     */
    public void moveR() 
    {
        x = x + movement.getX();
        y = y + movement.getY();
        if(x >= getWorld().getWidth()) {
            x = 0;
        }
        if(x < 0) {
            x = getWorld().getWidth() - 1;
        }
         if(y<=0)
      {
          getWorld().removeObject(this);  
      }
        if(y >= 549)
      {
          getWorld().removeObject(this);  
      }
      
        setLocation(x, y);
    }
    public void move() 
    {
       
        y = y - movement.getY();
        
        if(x < 0) {
            x = getWorld().getWidth() - 1;
        }
           if(y<=0)
      {
          y = getWorld().getHeight() - 225; 
      }
       if(y >= 550)
      {
          getWorld().removeObject(this);  
      }
      
        setLocation(x, y);
    }
    
    public void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }
    
    public void setLocation(int x, int y) 
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Increase the speed with the given vector.
     */
    public void increaseSpeed(Vector s) 
    {
        movement.add(s);
    }
    
    /**
     * Return the current movement.
     */
    public Vector getMovement() 
    {
        return movement;
    }
}