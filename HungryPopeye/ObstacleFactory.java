/**
 * Write a description of class ObstacleFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleFactory  
{
    static SpinachFactory l1;
    static CheeseFactory l2;
    static OliveFactory l3;
    public static Obstacle createObstacle(int y){
        Obstacle b = null;
        switch(y){
            case 1:
                b =  l1.getObstacle();
            break;
            
            case 2:
                b = l2.getObstacle();
            break;
            
            case 3:
                b = l3.getObstacle();
                
            default:
                break;
        }
        return b;
    
    }
}
