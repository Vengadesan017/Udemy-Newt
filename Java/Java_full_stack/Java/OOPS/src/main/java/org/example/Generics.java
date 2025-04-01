package org.example;

public class Generics<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

//    generic methods
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        Generics<Integer> integerBox = new Generics<>();
        integerBox.setValue(10);
        System.out.println(integerBox.getValue());  // Output: 10


        String[] strArray = {"Hello", "World"};

        printArray(strArray);

    }
}