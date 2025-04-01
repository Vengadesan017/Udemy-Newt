package org.example;

public class Main {
    public static void main(String[] args) {
        String ss = "100";
        System.out.println(Integer.parseInt(ss)+10);

        int a1 = 1000;
        byte a2 = (byte)a1;

        System.out.println(a1);

        switch (a1){
            case 1000:
                System.out.println("10");
                break;
            case 100:
                System.out.println("100");
                break;
            default:
                System.out.println("default");
        }

    for (int i = 1, j=1;(i<10) && (j<5); i++,j++){
        System.out.println(i);
        System.out.println(j);
    }

    int i = 1,j=1;
    while (true && i==j){
        System.out.println(i);
        break;
    }

//        switch (12.33){
//            case 1000:
//                System.out.println("10");
//                break;
//            case 100:
//                System.out.println("100");
//                break;
//            default:
//                System.out.println("default");
//        }
        System.out.println("haii hello \" ");

//      inheritence
        B bObj = new B();
        System.out.println(bObj);
    }
}