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
