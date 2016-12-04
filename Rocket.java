import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 */
public class Rocket extends Mover
{
    private int gunReloadTime;                  // The minimum delay between firing the gun.
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private Vector acceleration;                // How fast the rocket is.
    private int shotsFired;                     // Number of shots fired.
    
    private GreenfootImage rocket = new GreenfootImage("GALAga.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("GALAga.png");

    /**
     * Initilise this rocket.
     */
    public Rocket()
    {
       
        gunReloadTime = 10;
        reloadDelayCount = 0;
        acceleration = new Vector(0, .4);
        increaseSpeed(new Vector(0, 0)); // initially slowly drifting
        shotsFired = 0;
    }
   
    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        moveR();
        checkCollision();
        checkKeys();
        reloadDelayCount++;
        
        
        
         
         
    }
    
    /**
     * Return the number of shots fired from this rocket.
     */
    public int getShotsFired()
    {
        return shotsFired;
    }
    
    /**
     * Return the approximate current travelling speed of this rocket.
     */
    public int getSpeed()
    {
        return (int) (getMovement().getLength() * 0.1);
    }
    
    /**
     * Set the time needed for re-loading the rocket's gun. The shorter this time is,
     * the faster the rocket can fire. The (initial) standard time is 20.
     */
    public void setGunReloadTime(int reloadTime)
    {
        gunReloadTime = reloadTime;
    }
    
    /**
     * Check whether we are colliding with an asteroid.
     */
    private void checkCollision() 
    {
        Asteroid a = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if(a != null) {
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        ignite(Greenfoot.isKeyDown("right"));
        
               
        ignite2(Greenfoot.isKeyDown("left"));
        
        if(Greenfoot.isKeyDown("up")) 
        {
            fire();
        }        
    }
    
    /**
     * Should the rocket be ignited?
     */
    private void ignite(boolean boosterOn) 
    {
        if(boosterOn) {
            setImage(rocketWithThrust);
            acceleration.setDirection(0);
            increaseSpeed(acceleration);
        }
        else {
            setImage(rocket);        
        }
    }
    private void ignite2(boolean boosterOn) 
    {
        if(boosterOn) {
            setImage(rocketWithThrust);
            acceleration.setDirection(-180);
            increaseSpeed(acceleration);
        }
        else {
            setImage(rocket);        
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if(reloadDelayCount >= gunReloadTime) {
            Bullet b = new Bullet(getMovement().copy(), getRotation()-90);
            getWorld().addObject(b, getX(), getY());
            b.moveR();
            shotsFired++;
            reloadDelayCount = 0;
        }
    }
}