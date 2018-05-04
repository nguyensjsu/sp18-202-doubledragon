import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 // Colors and stuff
 // Fonts and stuff

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
        // super(600, 400, 1); 
         super(924, 520, 1);
        //super(700, 500, 1);
        // Adds the object, which has the 'checkKey' method to check whether the 'enter' is down or not.
        addObject(new Start(), 0, 0);
        showMessage();
        
    }
    
    /**
     * Displays some instructions and other stuff.
     */
    public void showMessage(){
        GreenfootImage bg = getBackground();
        
        
        bg.drawString("To start the game hit the ENTER button on your keyboard.",500, 400); 
        bg.setFont(new Font("Arial", 10));
        
    }
}
