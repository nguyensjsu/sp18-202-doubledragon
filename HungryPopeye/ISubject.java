import greenfoot.*;  
public interface ISubject {
 
    public void register(IObserver obj);
    public void unregister(IObserver obj);
     
    public void notifyObservers(Board world);
    
}