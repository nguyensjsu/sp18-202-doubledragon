import greenfoot.*;

public class Start extends Actor
{ 
    public void act() 
    {
        checkKey();
    } 
    
    public void checkKey(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Board());
        }    
    }
}