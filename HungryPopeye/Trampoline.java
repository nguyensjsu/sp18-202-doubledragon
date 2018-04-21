import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trampoline here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trampoline extends Actor
{
    /**
     * Act - do whatever the Trampoline wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Popeye myPopeye;
    public int numPop;
    GameManager gm = new GameManager();
    
    public void addedToWorld(World world)
    {
        newPopeye();
    }
    
    public void newPopeye()
    {
        myPopeye = new Popeye();
        getWorld().addObject (myPopeye, getX(), getY()-20);
        numPop ++;
       
    }
    
    public void act() 
    {
        /**
         * If the left arrow is pressed, the paddle moves 9 pixels to the left .
         * If the right arrow is pressed, the paddle moves 9 pixels to the right.
         */
        if (Greenfoot.isKeyDown ("left")) 
        {
            move(-9);
        }
        if (Greenfoot.isKeyDown ("right")) 
        {
            move(9);
        }
        if (havePopeye() && Greenfoot.isKeyDown ("space")) {
            //((Board)this.getWorld()).removeMessage4();
            releasePopeye();
            gm.setState(GameManager.GameStates.JUMPING);
        }
        
    }
    
    public boolean havePopeye()
    {
        return myPopeye != null;
    }
    
    public void releaseBall()
    {
        myPopeye.release();
        myPopeye = null;
        //concretesubject = ConcreteSubject.getInstance();
        //score = new Score(concretesubject);
        //concretesubject.register(score);
    }
}
