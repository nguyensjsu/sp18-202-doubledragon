import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CommandActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandActor extends Actor
{
    Trampoline t;
    GameInvoker myGameInvoker;
    ICommand startGame; 
    ICommand exitGame;
    IGameReceiver startGameRecevier,exitGameReceiver;
    boolean start = false;
    boolean exit = false;
    
    
    public void act() 
    {
              
        if (Greenfoot.isKeyDown("space")){    
            start = true;            
            callInvoker();
        }
        
        if (Greenfoot.isKeyDown("escape")){
            exit = true;
            callInvoker();
        }
    }    
    
    public CommandActor(Trampoline trampoline)
    {
        t = trampoline;
        myGameInvoker = new GameInvoker();
        startGameRecevier= new StartGameReceiver();
        exitGameReceiver= new ExitGameReceiver();
        startGame = new StartGameCommand(startGameRecevier, p);
        exitGame = new ExitGameCommand(exitGameReceiver, p);               
    }
    
    public void callInvoker(){
        
        if (t.havePopeye() && start){
             myGameInvoker.executeGame(startGame); 
        }
        
        if (exit){
            myGameInvoker.executeGame(exitGame); 
        }
    }

}
