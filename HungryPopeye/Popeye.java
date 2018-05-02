import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Popeye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Popeye extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int count = 2;
    private Popeye popeye;
    
    private boolean stuck = true;   // stuck to paddle
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
    
    public void act() 
    {
        // Add your action code here.
        if (!stuck)
        {
            move();
            //makeSmoke();
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
    
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        CollisionHandler objHandler;
        checkCollision();
        /*checkWalls();
        checkPaddle();
        checkBrick();
        checkBonus();*/
    }
    
    
    public void checkCollision()
    {
        String collisionObject = "";
        
        Popeye objPopeye = this;
        Board world = (Board)getWorld();
        
        CollisionHandler h1 = new WallCollision();
        CollisionHandler h2 = new PaddleCollision();
        CollisionHandler h3 = new SpinachCollision();
        CollisionHandler h4 = new CheeseCollision();
        CollisionHandler h5 = new OliveCollision();
        CollisionHandler h6 = new BonusCollision();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h3.setSuccessor(h4);
        h4.setSuccessor(h5);
        h5.setSuccessor(h6);
        
        h1.handleCollision("wall", objPopeye, getWorld().getWidth()-1);
        Actor trampoline = getOneIntersectingObject(Trampoline.class);
        if ( trampoline!= null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("paddle", objBall);
            h1.handleCollision("trampoline", objPopeye, trampoline.getX());
        }
        
        Actor cheese = getOneIntersectingObject(Cheese.class);
        if (cheese != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("banana", objBall);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("cheese", objPopeye, cheese.getX());
            ((Board)getWorld()).removeObject(cheese);
            //((Board)getWorld()).incrementScore();
            concretesubject.notifyObservers(world);
        }
        
        Actor spinach = getOneIntersectingObject(Spinach.class);
        if (spinach != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("banana", objBall);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("spinach", objPopeye, spinach.getX());
            ((Board)getWorld()).removeObject(spinach);
            concretesubject.notifyObservers(world);
        }
        
        Actor olive = getOneIntersectingObject(Olive.class);
        if (olive != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("banana", objBall);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("olive", objPopeye, olive.getX());
            ((Board)getWorld()).removeObject(olive);
            concretesubject.notifyObservers(world);
        }
    }
    

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
    
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }
    
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
}
