import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


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
    private Spinach Spinach;
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
        
        clientCmd = new CommandActor(trampoline);
        addObject(clientCmd,0,0);
        
        concretesubject = ConcreteSubject.getInstance();
        scores = new Score(concretesubject);
        concretesubject.register(scores);
              
        
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
                    message6 = new Message("Collect all spinachs!");
                    
                    addObject(message6,480, 30); 
                  
                    for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(1);
                        addObstacle(ob);
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
                   
                        addObstacle(ob);
                    }
                   
                    
                }
                if(level == 3)
                {
                    removeObject(message7);
                    message8 = new Message("Seems easy...right?");
                    addObject(message8,480, 30); 
                    
                  for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(3);
                   
                        addObstacle(ob);
                    }
                    trap = new Trap();
                    addObject(trap,490, 100);
                    addBonus();
                    
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
                    removeSpinachs();
                    
                    message9 = new Message("CONGRATULATIONS!");
                    addObject(message9,480, 30); 
                    
                   
                }
                                        
        }
    }
    
   
    public void checkBackground()
    {
           this.setBackground(backgroundImages[level%backgroundImages.length]);
    }
    
    
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
    
    
    public void incrementScore()
    {
        score ++;
        message1.setText("Score: " + score);
        upgradeLevel();
        //addTrap();
    }
    
    
    public void popeyeIsOut()
    {
       
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
   
    public void addObstacle(Obstacle o)
    
    {
        Obstacle temp;
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
   
    public void popeyeHitsBonus()
    {
          removeObject(bonus);
          trampoline.reduceNumPopeyes();
          addObject(life2, 860, 25);
         
          
    }
    
    
    public void removeMessage4()
    {
        this.removeObject(message4);
    }
    
    public void removeTraps()
    {
        removeObjects(getObjects(Trap.class));
    }
    
    
    public void removeBonus()
    {
        removeObjects(getObjects(Bonus.class));
    }
    
   
    public void removeSpinachs()
    {
        removeObjects(getObjects(Spinach.class));
    }
}
 