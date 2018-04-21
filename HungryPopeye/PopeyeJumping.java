/**
 * Write a description of class PopeyeJumping here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopeyeJumping extends GameState  
{

    /**
     * Constructor for objects of class PopeyeJumping
     */
    public PopeyeJumping(GameManager gm)
    {
        super(gm);
    }

    @Override
    public void die()
    {
        gm.setState(GameManager.GameStates.DEAD);
    }
}
