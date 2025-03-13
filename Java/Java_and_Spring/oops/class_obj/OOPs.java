package oops.class_obj;
class Cal {
    public int add(int a, int b){
        return a + b;
    }
    
}
public class OOPs {
    public static void main(String[] args) {
        int x =5;
        int y = 10;
         
        Cal obj = new Cal();
        System.out.println(obj.add(x,5));
    }
}
