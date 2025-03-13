package oops.inheritance;







public class Inheritance {
	public static void main(String a[]) 
	{
//		Calc obj=new Calc();
//		AdvCalc obj=new AdvCalc();
		AdvCalc obj=new AdvCalc();
		
		int r1=obj.add(5, 5);
		int r2=obj.sub(3,3);
		int r3=obj.multi(8,1);
		int r4=obj.div(15,8);

		
		System.out.println(r1+" "+r2+" "+r3+" "+r4);
		
	}
}
