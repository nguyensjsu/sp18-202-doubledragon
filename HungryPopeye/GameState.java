import greenfoot.*;

/*
    Game State Class for handling various states that game will have by implementing IGameState Interface.
*/


public class GameState implements IGameState
{
    GameManager gm;
    public GameState(GameManager gm)
    {    
        this.gm=gm;
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
