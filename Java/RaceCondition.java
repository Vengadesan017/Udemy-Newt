class Counter
{
	int count;
    // the synchronized block the count resouce to avoid the race condition
	public synchronized void increment()
	{
		count++;
	}
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException{   
    	
    	Counter c=new Counter();
    	
    	Runnable obj1=()->
    	{

    		for(int i=1;i<=20000;i++)
    		{
    			c.increment();
    		}
    	};
    	
    	Runnable obj2=()->
    	{

    		for(int i=1;i<=20000;i++)
    		{
    			c.increment();
    		}
    	};
    	
    	Thread t1=new Thread(obj1);
    	Thread t2=new Thread(obj2);
    	 	
    	t1.start();
    	t2.start();
    	
    	t1.join();
    	t2.join();  // wait for complete the 2 thread
    	
    	System.out.println(c.count);
    }
}

    