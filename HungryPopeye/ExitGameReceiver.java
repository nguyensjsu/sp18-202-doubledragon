import greenfoot.*;

public class ExitGameReceiver extends Actor implements IGameReceiver
{

    public void act() 
    {
        
    }    
    
    public void doAction(Trampoline t)
    {
      //System.out.println("Stop Game");
      //System.exit(0);
      Greenfoot.setWorld(new WelcomeInstructions());
      //Greenfoot.stop();
    }
}
