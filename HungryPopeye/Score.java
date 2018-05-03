import java.util.ArrayList;
import greenfoot.*; 

public class Score extends ConcreteObserver 
{
     
    public Score(ConcreteSubject sub)
    {
        super(sub) ;
    }
     public void update(Board world)
    {
        //world.incrementScore();
        /* int score = world.getScore();
        score++;
        world.setScore(score);
        world.upgradeLevel();*/
    }    
}