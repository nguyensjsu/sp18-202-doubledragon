import greenfoot.*;

/**
 * Write a description of class WallCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Popeye objPopeye, int location) {
        if(objectName.equals("wall")){
            //System.out.println("Entered into wall check" + objPopeye.getX() + " " + objPopeye.getY() + " " + objPopeye.getDeltaX());
            if (objPopeye.getX() == 0 || objPopeye.getX() == location){
            //if (objPopeye.getX() == 0 || objPopeye.getX() == 1){
                int deltaX = (-1 * objPopeye.getDeltaX());
                objPopeye.setDeltaX(deltaX);
            }
            if (objPopeye.getY() == 0) {
                int deltaY = (-1 * objPopeye.getDeltaY());
                objPopeye.setDeltaY(deltaY);
            }
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, location);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}
