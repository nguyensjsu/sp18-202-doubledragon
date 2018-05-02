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
    private Popeye popeye;  // used before popeye gets released
    public int numPopeye = 1; // Displays the number of Popeye. Starts on one standard
    GameManager gm = new GameManager();
    
    /**
     * When the Trampoline gets created, create a popeye as well.
     */
    public void addedToWorld(World world)
    {
        newPopeye();
    }
    
    public void act() 
    {
        // Add your action code here.
        
        /**
         * If the left arrow is pressed, the trampoline moves 9 pixels to the left .
         * If the right arrow is pressed, the trampoline moves 9 pixels to the right.
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
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (popeye != null) 
        {
            popeye.move (dist);
        }
    }
    
    public void newPopeye()
    {
        popeye = new Popeye();
        getWorld().addObject (popeye, getX(), getY()-20);
        numPopeye ++;
       
    }
        
    public boolean havePopeye()
    {
        return popeye != null;
    }
        
    public void releasePopeye()
    {
        popeye.release();
        popeye = null;
        //concretesubject = ConcreteSubject.getInstance();
        //score = new Score(concretesubject);
        //concretesubject.register(score);
    }
        
    public int getNumPopeyes()
    {
        return numPopeye;
    }
    
    /**
     * Method reduceNumPopeyes() decreases numPopeye with 1. This is necessary for the extra lives.
     */
    public void reduceNumPopeyes()
    {
        numPopeye = numPopeye -1;
        //concretesubject.unregister(score);
    }
    
    /**
     * Method removePopeye() removes the Popeye on the Trampoline.
     */
    public void removePopeye()
    {
        getWorld().removeObject(popeye);
        //concretesubject.unregister(score);
    }
}
