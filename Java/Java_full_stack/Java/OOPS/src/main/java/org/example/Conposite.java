package org.example;

public class Conposite {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Conposite() {
        this.name = "my name";
        this.value = 10;
    }

    public Conposite(Conposite tem) {
        this.name = tem.name;
        this.value = tem.value;
    }

    @Override
    public String toString() {
        return "Conposite{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public Conposite(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
