package oops;

interface A
{
	int age=28;          
	String area="Chennai";
	
	void show();
	void config();
}

interface B
{
	void run();
}
interface Y extends B
{
	
}

class C implements A,Y
{
	public void show()
	{
		System.out.println("in show");
	}
	public void config()
	{
		System.out.println("in cofing");
	}
	public void run()
	{
		System.out.println("running...");
	}
}

public class Interface {
    public static void main(String[] args) {

    	A obj;
    	obj=new C();
    	
    	obj.show();
    	obj.config();
        // obj.run();
    	
    	B obj1=new C();
    	obj1.run();
    	
    	C obj2=new C();
    	
    	obj2.show();
    	obj2.config();
        obj2.run();
    	

    	System.out.println(A.area);
        
    }
}