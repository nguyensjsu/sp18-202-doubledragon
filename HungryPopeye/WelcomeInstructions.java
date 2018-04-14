import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WelcomeInstructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeInstructions extends World
{

    /**
     * Constructor for objects of class WelcomeInstructions.
     * 
     */
    public WelcomeInstructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1); 
        showMessage();
    }
    
    public void showMessage(){
        GreenfootImage bg = getBackground();
        
        bg.setFont( new Font("Comic Sans MS",34));
        bg.setColor(Color.BLACK);
        bg.drawString("Welcome!", 380, 200);
        bg.setFont(new Font("Arial",12));
        
        
    }
}
