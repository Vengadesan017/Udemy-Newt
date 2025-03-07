package com.vengat.SpringBootWeb;

public class Student {
    private String name;
    private int regNo;

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", regNo=" + regNo +
                '}';
    }
}
