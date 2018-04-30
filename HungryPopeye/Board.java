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
    
    CommandActor clientCmd;
    ObstacleFactory b;
    Obstacle ob;
    private Trampoline trampoline; 
    private Olive olive;
    private Bonus bonus;
    private Trap trap;
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
        
        trampoline = new Trampoline();
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
                    message6 = new Message("Collect all olives!");
                    
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
                   
                    //increasePopeyeSpeed();
                    
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
                    //increasePopeyeSpeed();
                 //   Greenfoot.playSound("Try_This.mp3");
                                    }
                if(level == 4)
                {
                    removeObject(message8);
                    removeMessage4();
                    trampoline.removePopeye();
                    removeObject(trampoline);  
                    ConcreteSubject concretesubject = ConcreteSubject.getInstance();
                    concretesubject.unregister(scores);
                    removeTraps();
                    removeBonus();
                    removeOlives();
                    
                    message9 = new Message("CONGRATULATIONS!");
                    addObject(message9,480, 30); 
                    
                   // Greenfoot.playSound("Banana_song.mp3");
                }
                                        
        }
    }
    
    /**
     * The checkBackground() method sets the proper background as per current level.
     * 
     */
    public void checkBackground()
    {
           this.setBackground(backgroundImages[level%backgroundImages.length]);
    }
    
    /**
     * The endScreen () method indicates whether we are in level 4 or not . The method is called the Popeye class .
     */
    public boolean endScreen()
    {
        if(level == 4)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * De methode incrementScore() verhoogt de score met 1. 
     * Vervolgens worden de methode upgradeLevel() en addTrap() aangeroepen om te zien of deze moeten worden uitgevoerd.
     */
    public void incrementScore()
    {
        score ++;
        message1.setText("Score: " + score);
        upgradeLevel();
        //addTrap();
    }
    
    /**
     * The PopeyeIsOut () method tells you what to do if it is determined that the Popeye is not in the world where it should be.
     */
    public void popeyeIsOut()
    {
       // Greenfoot.playSound("Hohoho.mp3");
        if (trampoline.getNumPopeyes() > 3)
        {
            removeObject(life3);
            removeObject(message6);
            removeObject(message7);
            removeObject(message8);
            
            message5 = new Message("GAME OVER");
            addObject(message5,510, 30);
            ConcreteSubject concretesubject = ConcreteSubject.getInstance();
            concretesubject.unregister(scores);
        }
        else
        {
            if(trampoline.getNumPopeyes()==2)
            {
                removeObject(life1);
            }
            if(trampoline.getNumPopeyes()==3)
            {
                removeObject(life2);
            }
            
            trampoline.newPopeye();
            message4 = new Message("Press space to jump...");
            addObject(message4,480, 60);
        }
               
    }
        
    
    public void addObstacles(Obstacles o)
    
    {
        Obstacles temp;
        temp = o;
        int x = Greenfoot.getRandomNumber(814)+50;
        int y = Greenfoot.getRandomNumber(250)+70;
        addObject (temp, x , y);    
    }
    
    public void addTrap()
    {
        if (score == Greenfoot.getRandomNumber(10) + 20)
        {
            trap = new Trap();
            int x = Greenfoot.getRandomNumber(814)+50;
            int y = Greenfoot.getRandomNumber(250)+70;
            addObject (trap, x , y);
        }
    
    }
    
    /**
     * The method addBonus () place anywhere a bunch of olives for an extra life .
     * But only if the player has only one life at the start of level 2 or 3 (see upgrade level ()) 
     */
    public void addBonus()
    {
        if(trampoline.getNumPopeyes()==4)
        {
            bonus = new Bonus();
            int x = Greenfoot.getRandomNumber(814)+50;
            int y = Greenfoot.getRandomNumber(250)+70;
            addObject (bonus, x , y);
        }
    }
    
    /**
     * If the Popeye touches the bunch of olives (bonus) the player gets an extra life.
     */
    public void popeyeHitsBonus()
    {
          removeObject(bonus);
          popeye.reduceNumPopeyes();
          addObject(life2, 860, 25);
         // Greenfoot.playSound("Babanana.mp3");
          
    }
    
    /*public void increasePopeyeSpeed()
    {
        ((Popeye)(getObjects(Popeye.class).get(0))).incrementSpeed();
    }*/
    
    /**
     * This method removes message4 ( "Press space to jump ...").
     * This is called the Trampoline class .
     */
    public void removeMessage4()
    {
        this.removeObject(message4);
    }
    
    /**
     * The traps remove() method removes all Evil Minions (traps) present in the world.
     */
    public void removeTraps()
    {
        removeObjects(getObjects(Trap.class));
    }
    
    /**
     * The bonus remove() method removes all olive bunches (bonus) present in the world.
     */
    public void removeBonus()
    {
        removeObjects(getObjects(Bonus.class));
    }
    
    /**
     * The Olives remove() method removes all Olives present in the world .
     */
    public void removeOlives()
    {
        removeObjects(getObjects(Olive.class));
    }
}
