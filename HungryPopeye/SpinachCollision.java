import greenfoot.*;

/**
 * Write a description of class spinachCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpinachCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Popeye objPopeye, int spinachLocationX) {
        if(objectName.equals("spinach")){
            //System.out.println("Entered into spinach check");
            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - spinachLocationX;
            int deltaX = objPopeye.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objPopeye.setDeltaX(7);
            }
            if (deltaX < -7) {
                objPopeye.setDeltaX(-7);
            }
            //((Board)getWorld()).removeObject(spinach);
            //((Board)getWorld()).incrementScore();
            //Greenfoot.playSound("Baspinach.mp3");
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
