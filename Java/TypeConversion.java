public class TypeConversion {
    public static void main(String[] args) {
        //  casting
        byte a = 123;
        int b =a;   // implicit conversion
        int c = 123;
        // byte d =c;   // out of range error
        byte f =(byte) c;   // explicit conversion / casting

        //  type promotion
        int x = a * c ;
        System.out.println(b);
        System.out.println(c);
        System.out.println(f);
        System.out.println(x);
    }
}
