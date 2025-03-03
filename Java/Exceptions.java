class MyException extends Exception
{
	public MyException(String ss)
	{
		super(ss);
	}
}


class CheckedErrors1
{
	public void show() throws ClassNotFoundException
	{
   	// try                              instean of running code inside the try you forward the responsibelity to upper function
   	// {
   	// 	Class.forName("Calc");
   	// }
   	// catch(ClassNotFoundException e)
   	// {
   	// 	System.out.println("Not able to find class");
   	// }
		
		Class.forName("Calc");
	}
}


class CheckedErrors2{

	public void workWithThrows() throws ClassNotFoundException{
		CheckedErrors1 e1 = new CheckedErrors1();
		e1.show();
	}

}
public class Exceptions {
    public static void main(String[] args) {
    	
    	int i=0;
    	int j=0;
    	
    	int nums[]=new int[5];
    	String str="java";
    	
    	try
    	{

			CheckedErrors2 e2 = new CheckedErrors2();
			e2.workWithThrows();



			if(true){
				throw new MyException("Just pass the message here for my exception and forward to exception");
				// throw new ArithmeticException("Just pass the message here");
			}
    		j=18/i;
    		System.out.println(str.length());
    		System.out.println(nums[1]);
    		System.out.println(nums[15]);
    	}
    	catch(ArithmeticException e)
    	{	
    		System.out.println("ArithmeticException");
    		System.out.println(e);
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println(e);
    	}
    	catch(MyException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
  
    		System.out.println(e);
    	}
    	System.out.println(j);
    	System.out.println("Bye");
		
    }
}