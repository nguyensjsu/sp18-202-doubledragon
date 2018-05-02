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
    Obstacle ob;
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
        setPaintOrder ( Popeye.class, Smoke.class );
        
        Trampoline trampoline = new Trampoline();
        addObject ( trampoline, getWidth() / 2, getHeight() - 40);
       
        message1 = new Message("Score: " + score);
        addObject(message1, 125, 30);
        
        message2 = new Message("Level: " + level);
        addObject(message2,125, 60);
        
        message3 = new Message("Lives:");
        addObject(message3, 850, 30);
        
        message4 = new Message("Press space to jump...");
        addObject(message4, 480, 60);
                
        
        life1 = new Life();
        addObject(life1, 825,25);
        
        life2 = new Life();
        addObject(life2, 860,25);
        
        life3 = new Life();
        addObject(life3, 895,25);
        
        //clientCmd = new CommandActor(Trampoline);
        addObject(clientCmd,0,0);
        
        concretesubject = ConcreteSubject.getInstance();
        scores = new Score(concretesubject);
        concretesubject.register(scores);
        //wallCollision = new WallCollision(); 
        //addObject(wallCollision, 0, 0);        
        
        upgradeLevel();          
    }
    
    public void upgradeLevel()
    {
        if (score%10==0)
        {
            // Initial value of level is 0.
            level++;
            checkBackground();
            message2.setText("Level: " + level);
            
                if(level == 1)
                {
                    message6 = new Message("Collect all bananas!");
                    
                    addObject(message6,480, 30); 
                  
                    for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(1);
                        addObstacles(ob);
                    }
                }
                if(level == 2)
                {
                    removeObject(message6);
                    message7 = new Message("Don't get too friendly!");
                    addObject(message7,480, 30);
                    
                    
                  for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(2);
                   
                        addObstacles(ob);
                    }
                   
                    //increaseBallSpeed();
                    
                    //trap = new Trap();
                    //addObject(trap,490, 100);
                    Greenfoot.playSound("Steal_the_Moon.mp3");
                }
                if(level == 3)
                {
                    removeObject(message7);
                    message8 = new Message("Seems easy...right?");
                    addObject(message8,480, 30); 
                    
                  for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(3);
                   
                        addObstacles(ob);
                    }
                    trap = new Trap();
                    addObject(trap,490, 100);
                    addBonus();
                    //increaseBallSpeed();
                 //   Greenfoot.playSound("Try_This.mp3");
                                    }
                if(level == 4)
                {
                    removeObject(message8);
                    removeMessage4();
                    paddle.removeBall();
                    removeObject(Trampoline);  
                    ConcreteSubject concretesubject = ConcreteSubject.getInstance();
                    concretesubject.unregister(scores);
                    removeTraps();
                    removeBonus();
                    removeBananas();
                    
                    message9 = new Message("CONGRATULATIONS!");
                    addObject(message9,480, 30); 
                    
                   // Greenfoot.playSound("Banana_song.mp3");
                }
                                        
        }
    }
}
