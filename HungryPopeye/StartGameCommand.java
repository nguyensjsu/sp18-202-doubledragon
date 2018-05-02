import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGameCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameCommand extends Actor implements ICommand
{
    /**
     * Act - do whatever the StartGameCommand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private IGameReceiver changeGame;
    private Trampoline trampoline;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public StartGameCommand(IGameReceiver newGame, Trampoline t)   
    {
        this.changeGame = newGame;
        this.trampoline = t;
    }

    public void execute()
    {
        changeGame.doAction(trampoline);
    }

}
