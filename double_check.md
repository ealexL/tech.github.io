###双重检查机制(doucle-check)
#####通常在多线程并发时为防止线程阻塞而使用
```
public class DoubleCheck{
	private static DoubleCheck sDoubleCheck;
    public DoubleCheck getInstance(){
    	if(sDoubleCheck == null){
        	synchronized(this){
            	if(sDoubleCheck == null){
                	sDoubleCheck = new DoubleCheck();
                }
            }
        }
    	return sDoubleCheck;
    }
}
```
#####仔细研究，可以扩展使用：当读写分明的时候可使用
```
public class DoubleCheck{
	private static int num = 0;//需读取的数据
    public int getInstance(){
    	if(num < 100){
        	synchronized(this){//写操作需作同步
            	if(num < 100){//其实这句可以去掉
                	while(num<100){
                    	num++;//写操作
                    }
                }
            }
        }
    	return num;
    }
}
```