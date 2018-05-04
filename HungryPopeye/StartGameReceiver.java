import greenfoot.*;

/**
 * Write a description of class StartGameReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameReceiver extends Actor implements IGameReceiver
{
    Trampoline p;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction(Trampoline trampoline)
   {
        try
        {
            this.p = trampoline;
            p.releasePopeye();            
        }
        catch(Exception e){
        }
    }
}
