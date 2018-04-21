/**
 * Write a description of class PopeyeDead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopeyeDead extends GameState 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class PopeyeDead
     */
    public PopeyeDead(GameManager gm)
    {
        super(gm);
    }
    @Override
    public void start()
    {
        gm.setState(GameManager.GameStates.ONTRAMPOLINE);
       
    }
    
}
