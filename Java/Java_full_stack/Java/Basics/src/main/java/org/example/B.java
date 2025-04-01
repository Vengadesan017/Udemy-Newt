package org.example;

public class B extends A{
    private String bVar = "B..";
    public void bb(){
        System.out.println("A class method");
    }

    @Override
    public String toString() {
        return "B{" +
                "bVar='" + bVar + '\'' +
                '}' + super.toString();
    }
}
