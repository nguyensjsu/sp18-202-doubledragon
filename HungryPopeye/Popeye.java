import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The popeye game is a Popeye. It jumps around and bouncing off the walls and some other objects in the world.
 * 
 * @author CMPE 202 Project Team 12
 * @version 1.0
 */
public class Popeye extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int count = 2;
    private Popeye popeye;
    
    private boolean stuck = true;   // stuck to trampoline
    //ConcreteSubject concretesubject = new ConcreteSubject();
    private ConcreteSubject concretesubject;
    GameManager gm = new GameManager();
    
    public void setDeltaX(int deltaX) {
       this.deltaX = deltaX;
    }

    public int getDeltaX() {
       return deltaX;
    }
    
    public void setDeltaY(int deltaY) {
       this.deltaY = deltaY;
    }

    public int getDeltaY() {
       return deltaY;
    }
    
    /**
     * Act. Move if we're not stuck.
     */
    public void act()
    {
        if (!stuck)
        {
            move();
            makeSmoke();
            if(((Board) getWorld()).endScreen())
            {
                verticalBounce();
            }
            else
            {
                checkOut();
            }
        }
    }
    
    /**
     * Move the popeye. Then check what we've hit.
     */
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        CollisionHandler objHandler;
        checkCollision();
        /*checkWalls();
        checkTrampoline();
        checkBrick();
        checkBonus();*/
    }
    
    /**
     * Check whether we've hit one of the three walls. Reverse direction if necessary.
     */
    public void checkCollision()
    {
        //concretesubject = ConcreteSubject.getInstance();
        String collisionObject = "";
        /*
        if (getX() == 0 || getX() == getWorld().getWidth()-1){
            deltaX = -deltaX;
        }
        if (getY() == 0) {
            deltaY = -deltaY;
        }
        */
        //Popeye objPopeye = this.getClass();
        Popeye objPopeye = this;
        Board world = (Board)getWorld();
        
        CollisionHandler h1 = new WallCollision();
        CollisionHandler h2 = new TrampolineCollision();
        CollisionHandler h3 = new SpinachCollision();
        CollisionHandler h4 = new CheeseCollision();
        CollisionHandler h5 = new CherryCollision();
        CollisionHandler h6 = new BonusCollision();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h3.setSuccessor(h4);
        h4.setSuccessor(h5);
        h5.setSuccessor(h6);
        
        h1.handleCollision("wall", objPopeye, getWorld().getWidth()-1);
        Actor trampoline = getOneIntersectingObject(Trampoline.class);
        if (trampoline != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("trampoline", objPopeye);
            h1.handleCollision("trampoline", objPopeye, trampoline.getX());
        }
        
        Actor spinach = getOneIntersectingObject(Spinach.class);
        if (spinach != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("spinach", objPopeye);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("spinach", objPopeye, spinach.getX());
            ((Board)getWorld()).removeObject(spinach);
            //((Board)getWorld()).incrementScore();
            concretesubject.notifyObservers(world);
        }
        
        Actor cheese = getOneIntersectingObject(Cheese.class);
        if (cheese != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("spinach", objPopeye);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("cheese", objPopeye, cheese.getX());
            ((Board)getWorld()).removeObject(cheese);
            concretesubject.notifyObservers(world);
        }
        
        Actor olive = getOneIntersectingObject(Olive.class);
        if (olive != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("spinach", objPopeye);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("olive", objPopeye, olive.getX());
            ((Board)getWorld()).removeObject(olive);
            concretesubject.notifyObservers(world);
        }
        
        
        Actor bonus = getOneIntersectingObject(Bonus.class);
        if (bonus != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("bonus", objPopeye);
            h1.handleCollision("bonus", objPopeye, bonus.getX());
            ((Board) getWorld()).popeyeHitsBonus();
        }
    }
    
    /**
     * Check whether we're out (bottom of screen).
     */
    public void checkOut()
    {
        Actor trap = getOneIntersectingObject(Trap.class);
        // This condition checks for both intersection with Trap object and Popeye trampoline. 
        if (getY() == getWorld().getHeight()-1 || trap != null) 
        {
            ((Board) getWorld()).popeyeIsOut();
            getWorld().removeObject(this);
            gm.setState(GameManager.GameStates.DEAD);
        }
    }
    
    /**
     * The vertical bounce () method ensures that the Popeye ( popeye) continues to bounce around.
     */
    public void verticalBounce()
    {
        if (getY() == 0) 
        {
            deltaY = 7;
            deltaX = Greenfoot.getRandomNumber(20) - 10;
        }
        if (getY() == getWorld().getHeight()-1)
        {
            deltaY = -7;
            deltaX = Greenfoot.getRandomNumber(20) - 10;
        }
    }
    /*
    public void checkTrampoline()
    {
        Actor trampoline = getOneIntersectingObject(Trampoline.class);
        if (trampoline != null) {
            deltaY = -deltaY;
            int offset = getX() - trampoline.getX();
            deltaX = deltaX + (offset/10);
                if (deltaX > 7) {
                    deltaX = 7;
                }
                if (deltaX < -7) {
                    deltaX = -7;
                }
            Greenfoot.playSound("Yahoo.wav");
        }            
    }
    */
    /**
      * The checkBrick() method checks if the Popeye ( popeye) collided with a spinach (brick).
      * If this is the case, remove the spinach (brick), increase the score, release the Popeye (popeye) away again.
      * The Popeye (popeye) starts singing the word BANANA. */
   /* 
   public void checkBrick()
    {
        Actor brick = getOneIntersectingObject(Brick.class);
        if (brick !=null)
        {
            deltaY = -deltaY;
            int offset = getX() - brick.getX();
            deltaX = deltaX + (offset/10);
                if (deltaX > 7) {
                    deltaX = 7;
                }
                    if (deltaX < -7) {
                        deltaX = -7;
                    }
                        
            ((Board)getWorld()).removeObject(brick);
            ((Board)getWorld()).incrementScore();
            //Greenfoot.playSound("Baspinach.mp3");
        }
    }
    */
    /**
     * The check bonus () method checks if the Popeye ( popeye) collides with a bunch of spinachs (bonus) .
     * If so, is bouncing the Popeye ( popeye) away again.
     * Then the popeye hits bonus () method output from the Board class .
     */
    /*
    public void checkBonus()
    {
        Actor bonus = getOneIntersectingObject(Bonus.class);
        if (bonus !=null)
        {
            deltaY = -deltaY;
            int offset = getX() - bonus.getX();
            deltaX = deltaX + (offset/10);
                if (deltaX > 7) {
                    deltaX = 7;
                }
                    if (deltaX < -7) {
                        deltaX = -7;
                    }
            ((Board) getWorld()).popeyeHitsBonus();            
          
        }
    }
    */
    /**
     * Move the popeye a given distance sideways.
     */
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }

    /**
     * Put out a puff of smoke (only on every second call).
     */
    public void makeSmoke()
    {
        count--;
        if (count == 0) {
            getWorld().addObject ( new Smoke(), getX(), getY());
            count = 2;
        }
    }
    
    /**
     * Release the popeye from the trampoline.
     */
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        while(deltaX == 0)
            deltaX = Greenfoot.getRandomNumber(11) - 5;
            //deltaX = 2;
        deltaY = -5;
        stuck = false;
        Greenfoot.playSound("Yahoo.wav");      
    }
    
    /**
     * The incrementSpeed() method increments the speed of the Popeye ( popeye). 
     */
    /*public void incrementSpeed()
    {
        deltaX = deltaX - 2;
        deltaY = deltaY - 2;
    }*/
  
}