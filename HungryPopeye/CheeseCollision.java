import greenfoot.*;

/**
 * Write a description of class CherryCol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class CherryCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;

    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}

