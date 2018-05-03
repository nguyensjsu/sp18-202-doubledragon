import greenfoot.*;

<<<<<<< HEAD
public class CheeseCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;

    public void handleCollision(String objectName, Popeye objPopeye, int cheeseLocationX) {
        if(objectName.equals("cheese")){

            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - cheeseLocationX;
=======
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
            // System.out.println("Entered into cheese check");
            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - brickLocationX;
>>>>>>> 249d333458576ebd91e3f54b243a6766a2d63d10
            int deltaX = objPopeye.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objPopeye.setDeltaX(7);
            }
            if (deltaX < -7) {
                objPopeye.setDeltaX(-7);
            }
<<<<<<< HEAD
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, cheeseLocationX);
            }    
        }
    }
    
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}
=======
            // Greenfoot.playSound("mp3");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, brickLocationX);
            }    
        } 	
    }
}

>>>>>>> 249d333458576ebd91e3f54b243a6766a2d63d10
