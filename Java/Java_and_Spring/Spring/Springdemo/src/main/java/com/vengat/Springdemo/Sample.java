package com.vengat.Springdemo;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sample {
    @Autowired
    ClassTwo objauto;
    public void haii(){
        System.out.println("Haiii");
        objauto.checking();
    }
}
