import greenfoot.*;

/**
 * Write a description of class StartGameReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameReceiver extends Actor implements IGameReceiver
{
    Trampoline t;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction(Trampoline trampoline)
   {
        try
        {
            this.t = trampoline;
            t.releasePopeye();            
        }
        catch(Exception e){
        }
    }
}
