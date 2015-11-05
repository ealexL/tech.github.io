#####1.定义一个观察者，并定义观察者动作
```
public interface Observer{
    void update()；
    void update(Parameter)；
    ...
}
```

#####2.规范管理观察者
````
public interface ObserverManagerInterface{
    void addObserver(Observer observer);
    void notifyObserver(int id);
    void notifyObserver(Observer observer);
    void notifyObserver();
    void removeObserver(Observer observer);
    void clearObserver();
    int countObserver();
}
````
#####3.实现
```
public class ObserverManager impelments ObserverManagerInterface{
    private int count; //观察者的总数
    private List<Observer> observers = new ArrayList<Observer>(); //缓存观察者
    private static int i= 0;
    private ObserverManagerInterface mObserverManagerInterface;
    public ObserverManagerInterface getInstance(){
		if (mObserverManagerInterface == null) {
			synchronized (ObserverManager.class) {
				if (mObserverManagerInterface == null)
					mObserverManagerInterface = new ObserverManager();
			}
		}
		return mObserverManagerInterface;
    }
    public abstract void addObserver(Observer observer){
    	if(observer != null && observers != null)
        	observers.add(observer);
    };
    public void notifyObserver(Observer observerE){
    	for(Observer observer : observers){
        	if(observer.equel(observerE)){
            	observer.update();
                //observer.update(parameter);
            }
        }
    };
    public void notifyObserver(){
    	for(Observer observer : observers){
        	observer.update();
            //observer.update(parameter);
        }
    };
    public boolean removeObserver(Observer observer){
        return observers.remove(observer);
    };
    public void clearObserver(){
    	observers.clean();
    };
    public int countObserver(){
        count = observers.size();
    return count;
    }
}
```


