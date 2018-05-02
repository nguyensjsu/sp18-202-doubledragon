import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitGameCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitGameCommand extends Actor implements ICommmand
{
    private IGameReceiver changeGame;
    private Trampoline trampoline;
        
    public void act() 
    {
        // Add your action code here.
    } 

    /**
     * Constructor for objects of class exitGame
     */
    public ExitGameCommand(IGameReceiver newGame, Trampoline t)
    {
        this.changeGame=newGame;
        this.trampoline = t;
    }
    
    public void execute()
    {
        changeGame.doAction(trampoline);
    }       

}
