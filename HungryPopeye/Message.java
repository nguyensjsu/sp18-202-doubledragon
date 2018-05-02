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
    
    public Message(String theText, int theWidth, int theHeight)
    {
        text = theText;
        width = theWidth;
        height = theHeight;
        updateImage();
    }
    
    public void setText(String theText)
    { 
        text = theText;
        updateImage();
    }
    
    private void updateImage()
    {
        Font font = new Font("Helvetica",20);
        GreenfootImage image = new GreenfootImage(width,height);
        image.setFont(font);
        image.clear();
        image.setColor(Color.BLUE);
        image.drawString(text, 5, height / 2);
        setImage(image);
    }  
}
