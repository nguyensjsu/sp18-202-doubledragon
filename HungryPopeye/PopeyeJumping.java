import greenfoot.*;

/**
 * Write a description of class PopeyeJumping here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopeyeJumping extends GameState
{

    /**
     * Constructor for objects of class PopeyeJumping.
     * 
     */
    public PopeyeJumping(GameManager g)
    {
        super(g);
    }
    
    @Override
    public void die()
    {
        gm_manager.setState(GameManager.GameStates.DEAD);
        //System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
   
}
