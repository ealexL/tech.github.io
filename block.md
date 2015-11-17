#Block
####没有函数名，有函数体
####1.普通的代码块
#####普通的代码块位于普通的函数(方法)中，代码执行的优先级在代码块类别中最低，例如：
	public class ExampleClass{
        private void normalMethod(){
    		//普通的代码块
    		{
				System.out.println("这是普通的代码块");
        	}
            System.out.println("这在普通的代码块外面一层");
        }
    }
####2.构造代码块
#####构造代码块与构造函数同一级，代码执行的优先级高于普通的代码块，例如：
	public class ExampleClass{
    	public ExampleClass(){
        	System.out.println("这是构造函数");
        }
    	public void normalMethod(){
    		//普通的代码块
    		{
				System.out.println("这是普通的代码块");
        	}
            System.out.println("这在普通的代码块外面一层");
        }
        {
        	System.out.println("这是构造代码块");
        }
    }
####3.静态代码块
#####静态代码块是在构造代码块基础上加上静态标志，*需要注意的是：静态代码块只执行第一次，之后的实例化以及方法的调用都不执行，直到程序被kill*，如：
```
	public static class ExampleClass{
    	public ExampleClass(){
        	System.out.println("这是构造函数");
        }
    	public void normalMethod(){
    		//普通的代码块
    		{
				System.out.println("这是普通的代码块");
        	}
            System.out.println("这在普通的代码块外面一层");
        }
        {
        	System.out.println("这是构造代码块");
        }
        static{
        	System.out.println("这是静态代码块");
        }
        public static void staticNormalMethod(){
        	System.out.println("这是静态方法");
        }
    }
```
####3.同步代码块
######常在java的多线程程序中为保证线程安全而使用，这部分另开篇写

####4.不同代码块的执行顺序
#####1)无继承
   a)类的启动方式---直接实例化：
```
ExampleClass mExampleClass = new ExampleClass();
mExampleClass.normalMethod();
```
静态代码块-->构造代码块-->构造函数-->普通的代码块-->这在普通的代码块外面一层
   b)类的启动方式---调用静态方法：
```
ExampleClass.staticNormalMethod();
```
静态代码块-->静态方法(并不执行构造代码块和构造函数)

#####2)继承,如下：
   	public static class ExampleClass{
		public ExampleClass(){
        	System.out.println("这是构造函数");
        }
    	public void normalMethod(){
    		//普通的代码块
    		{
				System.out.println("这是普通的代码块");
        	}
            System.out.println("这在普通的代码块外面一层");
        }
        {
        	System.out.println("这是构造代码块");
        }
        static{
        	System.out.println("这是静态代码块");
        }
        public static void staticNormalMethod(){
        	System.out.println("这是静态方法");
        }
    }
   	public static class ChildExampleClass extends ExampleClass{
		public ChildExampleClass(){
        	System.out.println("这是子类构造函数");
        }
    	public void normalMethod(){
    		//普通的代码块
    		{
				System.out.println("这是子类普通的代码块");
        	}
            System.out.println("这在子类普通的代码块外面一层");
        }
        {
        	System.out.println("这是子类构造代码块");
        }
        static{
        	System.out.println("这是子类静态代码块");
        }
        public static void staticNormalMethod(){
        	System.out.println("这是子类静态方法");
        }
    }
   a)类的启动方式---直接实例化：	
	
    ChildExampleClass mChildExampleClass = new ChildExampleClass();
   	
    mChildExampleClass.normalMethod();
父类静态代码块-->子类静态代码块-->父类构造代码块-->父类构造函数-->子类构造代码块-->子类构造函数-->子类普通的代码块-->这在普通的代码块外面一层
   b)类的启动方式---调用静态方法：
	
    ChildExampleClass.staticNormalMethod();
静态代码块-->静态方法-->构造代码块-->构造函数
父类静态代码块-->子类静态代码块-->子类静态方法