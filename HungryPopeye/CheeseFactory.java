/**
 * Write a description of class CheeseFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheeseFactory extends ObstacleFactory 
{
    // instance variables - replace the example below with your own
   public static Obstacle getObstacle(){
       return new Cheese();
   }
}
