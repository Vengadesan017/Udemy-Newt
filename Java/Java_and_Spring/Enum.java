enum Nums{
	one(5), Two(10), Three();

    // ++++++++++
    private int n;

    private Nums(int n) {
        this.n = n;
    }

    private Nums(){  // update the default value for un seted enum
        n=100;
    }
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    
}

public class Enum {
    public static void main(String[] args) {


   	Nums s= Nums.Two;
   	System.out.println(s);    // constand variable value
   	System.out.println(s.ordinal());   // index value
    	
    Nums[] ss=Nums.values();
    System.out.println(ss);
    
    for(Nums e:ss)
    {
        System.out.println(e+" : "+e.ordinal() + " n = " + e.getN());
    }
    
    // Also use inif switch case   if ()
    //   not able to extends
     
    System.out.println(s.getClass() + "," + s.getClass().getSuperclass());
    }
}
