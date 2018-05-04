import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Trampoline extends Actor
{
    private Popeye myPopeye;  // used before popeye gets released
    public int numPopeye = 1; // Displays the number of Popeye ( popeye). Starts on one standard
    GameManager gm = new GameManager();
    //ConcreteSubject concretesubject = new ConcreteSubject();
    //private ConcreteSubject concretesubject;
    //private Score score;
       
    /**
     * When the trampoline gets created, create a popeye as well.
     */
    public void addedToWorld(World world)
    {
        newPopeye();
    }
    
    /**
     * Act - do whatever the Trampoline wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
            ((Board)this.getWorld()).removeMessage4();
            releasePopeye();
            gm.setState(GameManager.GameStates.JUMPING);
        }
        
    }
    
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myPopeye != null) 
        {
            myPopeye.move (dist);
        }
    }
    
    public void newPopeye()
    {
        myPopeye = new Popeye();
        getWorld().addObject (myPopeye, getX(), getY()-20);
        numPopeye ++;
       
    }
        
    public boolean havePopeye()
    {
        return myPopeye != null;
    }
        
    public void releasePopeye()
    {
        myPopeye.release();
        myPopeye = null;
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
     * Method removePopeye() removes the Popeye ( popeye) on the trampoline.
     */
    public void removePopeye()
    {
        getWorld().removeObject(myPopeye);
        //concretesubject.unregister(score);
    }
}
