import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 */
public class Bullet extends Mover
{
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    /** The damage this bullet will deal */
    private int damage = 500;
    
    public Bullet()
    {
    }
    
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        increaseSpeed(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
          if(y >= 550)
      {
          getWorld().removeObject(this);  
      }
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            moveR();
            Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
            if(asteroid != null){
                getWorld().removeObject(this);
                asteroid.hit(damage);
            }
            else {
                life--;
            }
        }
    }
}