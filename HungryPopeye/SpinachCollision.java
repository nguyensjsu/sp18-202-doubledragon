import greenfoot.*;
<<<<<<< HEAD

public class SpinachCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;

    public void handleCollision(String objectName, Popeye objPopeye, int spinachLocationX) {
        if(objectName.equals("spinach")){

            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - spinachLocationX;
=======
public class SpinachCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Popeye objPopeye, int brickLocationX) {
        if(objectName.equals("apple")){
            //System.out.println("Entered into brick check");
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
                successor.handleCollision(objectName, objPopeye, spinachLocationX);
            }    
        }
    }
    
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}
=======
            //((Board)getWorld()).removeObject(brick);
            //((Board)getWorld()).incrementScore();
            // Greenfoot.playSound("mp3");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, brickLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
   
}
>>>>>>> 249d333458576ebd91e3f54b243a6766a2d63d10
