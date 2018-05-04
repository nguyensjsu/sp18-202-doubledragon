import greenfoot.*;

/**
 * Write a description of class BonusCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Popeye objPopeye, int bonusLocationX) {
        if(objectName.equals("bonus")){
            //System.out.println("Entered into bonus check");
            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - bonusLocationX;
            int deltaX = objPopeye.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objPopeye.setDeltaX(7);
            }
            if (deltaX < -7) {
                objPopeye.setDeltaX(-7);
            }
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, bonusLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}
