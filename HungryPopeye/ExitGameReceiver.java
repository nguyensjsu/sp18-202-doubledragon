import greenfoot.*;

public class ExitGameReceiver extends Actor implements IGameReceiver
{

    public void act() 
    {
        
    }    
    
    public void doAction(Paddle paddle)
    {
      //System.out.println("Stop Game");
      //System.exit(0);
      Greenfoot.setWorld(new WelcomeInstructions());
      //Greenfoot.stop();
    }
}