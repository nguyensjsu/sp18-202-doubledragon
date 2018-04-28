import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{

    private String[] backgroundImages = {"level0.jpg","level1.jpg","level2.jpg","level3.jpg","level4.jpg"};
    private int score = 0;
    private int level = 0;
    
    private Message message1 = null;
    private Message message2 = null;
    private Message message3 = null;
    private Message message4 = null;
    private Message message5 = null;
    private Message message6 = null;
    private Message message7 = null;
    private Message message8 = null;
    private Message message9 = null;
    
    //CommandActor clientCmd;
    ObstacleFactory b;
    Obstacles ob;
    private Trampoline trampoline; 
    private Cheese Banana;
    //private Bonus bonus;
    //private Trap trap;
    private Popeye popeye;
    private Life life1;
    private Life life2;
    private Life life3;
    private ConcreteSubject concretesubject;
    private Score scores;
    
    public Board()
    {    
        // Construct a new world. Width, Height and cellSize
        super(924, 520, 1);
    }
}
