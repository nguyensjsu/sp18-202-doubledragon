/**
 * Write a description of class OliveFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OliveFactory extends ObstacleFactory 
{
    // instance variables - replace the example below with your own
    public static Obstacle getObstacle(){
       return new Olive();
   }
}
