public class Datatype {
    public static void main(String[] vv){
        
        // primitive data type 
		byte byteMax = 127;
		byte byteMin = -128;
		System.out.println("byte " +byteMin+" to "+byteMax);
		
		short shortMax = 32767;
		short shortMin = -32768;
		System.out.println("Short " +shortMin+" to "+shortMax);
		
		int maxInt = 2147483647;
		int minInt = -2147483648;
		int a = 0b101;
		int b = 0x1E1;
		int c = 100_00_000;
		System.out.println("Int " +minInt+" to "+maxInt);
		System.out.println("a " +a+" b "+b+" c " +c);
		
		long maxLong = 9223372036854775807L;
		long minLong = -9223372036854775808l;
		System.out.println("Long " +minLong+" to "+maxLong);

		float f=3234.141243278345f;
		double d=3456.14124512345678902345678914f;
		double dd=3456.14124512345678902345678914;
		double ddd=3456.13e10;
		System.out.println("float "+f+", double"+d);
		System.out.println("float "+f+", double"+dd+" ddd "+ddd);
		
		boolean flag=false;
		System.out.println("boolean"+flag);

        char ch = 'a';
        System.out.println(ch);
        
        char ch1 = 65;
        System.out.println(ch1);
        
        char var1 = '\u00A7';
        System.out.println(var1);
        //   && || !


        
    }
}
