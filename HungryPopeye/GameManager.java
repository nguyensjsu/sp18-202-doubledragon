/**
 * Write a description of class GamaManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager  
{
    // instance variables - replace the example below with your own
    IGameState onTrampolineState;
    IGameState jumpingState;
    IGameState deadState;
    IGameState currentState;

    public enum GameStates
    {
        ONTRAMPOLINE,JUMPING,DEAD,
    };
    /**
     * Constructor for objects of class GamaManager
     */
    public GameManager()
    {
       onTrampolineState=new PopeyeOnTrampoline(this);
       jumpingState=new PopeyeJumping(this);
       deadState=new PopeyeDead(this);
       currentState=onTrampolineState;
    }
    public void onpaddle()
    {
        System.out.println("on the paddle");
        currentState.start();
    }
    
    public void jump()
    {
        System.out.println("on the paddle");
        currentState.doJumping();
    }
    
    public void dead()
    {
        System.out.println("on the paddle");
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
