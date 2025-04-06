package com.vengat.FoodBySpringBoot.Controller;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vengat.FoodBySpringBoot.Services.AccountService;
import com.vengat.FoodBySpringBoot.Services.PostService;
import com.vengat.FoodBySpringBoot.models.Account;
import com.vengat.FoodBySpringBoot.models.Post;

import jakarta.validation.Valid;




@Controller
public class MyController {
    @Autowired
    private PostService postService;



    @GetMapping("/")
    public String home(Model model) {
        
        List<Post> post = postService.findAll();
        // Post post = optionalPost.get();
        model.addAttribute("posts", post);
        System.out.println();
        System.out.println(post);
        return "home";

    }

    
    
}
