import greenfoot.*;

 public class CheeseCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;

    public void handleCollision(String objectName, Popeye objPopeye, int cheeseLocationX) {
        if(objectName.equals("cheese")){
            // System.out.println("Entered into cheese check");
            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - cheeseLocationX;
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
                successor.handleCollision(objectName, objPopeye, cheeseLocationX);
            }    
        }
    }
    
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}