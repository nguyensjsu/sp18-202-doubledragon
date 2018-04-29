import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrampolineCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrampolineCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Popeye objPopeye, int trampolineLocationX) {
        if(objectName.equals("trampoline")){
            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - trampolineLocationX;
            int deltaX = objPopeye.getDeltaX() + (offset/10);
                if (deltaX > 7) {
                    objPopeye.setDeltaX(7);
                }
                if (deltaX < -7) {
                    objPopeye.setDeltaX(-7);
                }
            Greenfoot.playSound("Yahoo.wav");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, trampolineLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }

}
