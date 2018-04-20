/**
 * Write a description of class PopeyeOnTrampoline here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopeyeOnTrampoline extends GameState
{
   
    /**
     * Constructor for objects of class PopeyeOnTrampoline
     */
    public PopeyeOnTrampoline(GameManager gm)
    {
        super(gm);
    }

    @Override
    public void doJumping()
    {
        gm.setState(GameManager.GameStates.JUMPING);
        
    }
}
