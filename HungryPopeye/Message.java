import greenfoot.*; 

public class Message  extends Actor
{

    public void act() 
    {
        
    }
    
    private String text;
    
    // dimensions of board

    private int width = 220;
    private int height = 30;

    //constructor
    public Message(String theText)
    {
        text = theText;
        updateImage();
    }
    
}
