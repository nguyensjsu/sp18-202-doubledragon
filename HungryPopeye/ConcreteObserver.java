import greenfoot.*;  

public class ConcreteObserver implements IObserver
{
        protected ConcreteSubject subject;
        public  ConcreteObserver(ConcreteSubject sub)
        {
            this.subject = sub;
        }
        
        public void update(Board world)
        {
        }
}
