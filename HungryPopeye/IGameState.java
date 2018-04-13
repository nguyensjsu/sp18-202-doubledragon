import greenfoot.*;

/*
	IGameState Interface which has methods related state of Game.
*/

public interface IGameState 
{

    public void start();
    
    public void doJumping();
    
    public void die();
}
