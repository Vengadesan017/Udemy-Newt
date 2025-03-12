package com.vengat.SpringAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String Helloo(){
        return "hello...";
    }
    @GetMapping("/")
    public String welcome(){
        return "Welcome to vengat project";
    }
}
