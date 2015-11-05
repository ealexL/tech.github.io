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
public abstract class ObserverManager impelments ObserverManagerInterface{
    int count; //观察者的总数
    HashMap<Integer,Observer>> observers = new HashMap<Integer,Observer>(); //缓存观察者
    private static int i= 0;
    public abstract void addObserver(Observer observer){
        observers.put(i++,observer);
    };
    public void notifyObserver(int id){};
    public void notifyObserver(Observer observer){};
    public void notifyObserver(){};
    public void removeObserver(Observer observer){};
    public void clearObserver(){};
    public int countObserver(){
        count = observers.size();
    return count;
    }
}
```


