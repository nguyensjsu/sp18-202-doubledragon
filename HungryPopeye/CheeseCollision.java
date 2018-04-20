import greenfoot.*;

/**
 * Write a description of class CherryCol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class CheeseCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;

    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }

    public void handleCollision(String objectName, Popeye objPopeye, int brickLocationX) {
        if(objectName.equals("cheese")){
            System.out.println("Entered into cheese check");
            
            //((Board)getWorld()).removeObject(brick);
            // //((Board)getWorld()).incrementScore();
            // Greenfoot.playSound("mp3");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objBall, brickLocationX);
            }    
        } 	
    }
}

