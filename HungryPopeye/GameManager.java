import greenfoot.*;

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager
{
    IGameState onTrampolineState;
    IGameState jumpingState;
    IGameState deadState;
    IGameState currentState;
    public enum GameStates
    {
        ONTRAMPOLINE,JUMPING,DEAD,
    };

    /**
     * Constructor for objects of class GameManager.
     * 
     */
    public GameManager()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       // super(600, 400, 1); 
       onTrampolineState=new PopeyeOnTrampoline(this);
       jumpingState=new PopeyeJumping(this);
       deadState=new PopeyeDead(this);
       currentState=onTrampolineState;
    }
    
    public void ontrampoline()
    {
        System.out.println("on the trampoline");
        currentState.start();
    }
    
    public void jump()
    {
        System.out.println("on the trampoline");
        currentState.doJumping();
    }
    
    public void dead()
    {
        System.out.println("on the trampoline");
        currentState.die();
    }
    
    public void setState(GameStates nextState)
    {
        switch(nextState)
        {
            case ONTRAMPOLINE: currentState=onTrampolineState; break;
            case JUMPING: currentState=jumpingState; break;
            case DEAD: currentState=deadState; break;
        }
    }
    
    public void showState()
    {
        System.out.println("Current State:"+currentState.getClass().getName());
    }
}
