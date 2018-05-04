import greenfoot.*;

/**
 * Write a description of class OnTrampoline here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopeyeOnTrampoline extends GameState
{

    public PopeyeOnTrampoline(GameManager g)
    {    
        super(g); 
    }
    
   
    @Override
    public void doJumping()
    {
        gm_manager.setState(GameManager.GameStates.JUMPING);
        //System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
    
   
}
