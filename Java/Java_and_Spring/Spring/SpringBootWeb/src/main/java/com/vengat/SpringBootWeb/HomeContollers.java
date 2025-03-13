package com.vengat.SpringBootWeb;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeContollers {

    @ModelAttribute("name")
    public String IAm(){
        return "Vengadesan...";
    }


    @RequestMapping("/")
    public String home(){
        System.out.println("hello");
        return "index";
    }

    @RequestMapping("mul")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b, HttpSession session){
        session.setAttribute("result",a*b);
        System.out.println(a*b);
        return "result";

    }

    @RequestMapping("addStudent")
        public String addStudent(@ModelAttribute("stu") Student student) {

        return "result";
    }
}
