import greenfoot.*;

/**
 * Write a description of class PopeyeDead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopeyeDead extends GameState
{
    /**
     * Constructor for objects of class PopeyeDead.
     * 
     */    
    public PopeyeDead(GameManager g)
    {
        super(g);
    } 
    
   @Override
    public void start()
    {
        gm_manager.setState(GameManager.GameStates.ONTRAMPOLINE);
        //System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
}
