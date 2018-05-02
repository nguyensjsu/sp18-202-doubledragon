import greenfoot.*;

public class OliveCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;

    public void handleCollision(String objectName, Popeye objPopeye, int oliveLocationX) {
        if(objectName.equals("olive")){

            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - oliveLocationX;
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
                successor.handleCollision(objectName, objPopeye, oliveLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
<<<<<<< HEAD
=======

>>>>>>> 887f72f9440e2f6236ca94f44241fdf0b6d00267
}