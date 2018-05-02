import greenfoot.*;

public class ExitGameReceiver extends Actor implements IGameReceiver
{

    public void act() 
    {
        
    }    
    
<<<<<<< HEAD
    public void doAction(Trampoline t)
=======
    public void doAction(Trampoline trampoline)
>>>>>>> 887f72f9440e2f6236ca94f44241fdf0b6d00267
    {
      //System.out.println("Stop Game");
      //System.exit(0);
      Greenfoot.setWorld(new WelcomeInstructions());
      //Greenfoot.stop();
    }
}
