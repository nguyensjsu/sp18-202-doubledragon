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
        super(900, 600, 1); 
        showMessage();
    }
    
    public void showMessage(){
        GreenfootImage bg = getBackground();
        
        bg.setFont( new Font("Comic Sans MS",34));
        bg.setColor(Color.BLACK);
        bg.drawString("", 380, 200);
        bg.setFont(new Font("Arial",12));
        bg.drawString("Instructions:",420, 230); 
        bg.drawString("- Use the arrow keys to move the Trampoline",340, 250); 
        bg.drawString("- Popeye life decreases for every time he falls off the Trampoline",280, 270); 
    
        bg.drawString("- You can see your score at the top left corner",325, 290); 
        bg.drawString("Have fun and enjoy the game!", 365, 350); 
        bg.setFont(new Font("Arial",22));
        bg.drawString("Hit ENTER to start the game",200, 400); 
        bg.setFont(new Font("Arial",10));
        
        
    }
}
