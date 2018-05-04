import greenfoot.*;

/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState implements IGameState
{
 
    GameManager gm_manager;
  
    public GameState(GameManager gm)
    {    
        gm_manager=gm;
    }
    
    public void start()
    {
        System.out.println("On trampoline is not valid in "+this.getClass().getName()+" state");
    }
    
    public void doJumping()
    {
        System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
    
    public void die()
    {
        System.out.println("Dead is not valid in "+this.getClass().getName()+" state");
    }
    
}
