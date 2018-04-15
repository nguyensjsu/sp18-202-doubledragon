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
    

}
