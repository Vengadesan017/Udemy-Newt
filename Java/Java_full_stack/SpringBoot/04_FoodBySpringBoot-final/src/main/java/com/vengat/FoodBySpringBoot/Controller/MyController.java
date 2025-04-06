package com.vengat.FoodBySpringBoot.Controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vengat.FoodBySpringBoot.Services.AccountService;
import com.vengat.FoodBySpringBoot.Services.PostService;
import com.vengat.FoodBySpringBoot.models.Account;
import com.vengat.FoodBySpringBoot.models.Post;
import java.util.stream.IntStream;

import jakarta.validation.Valid;




@Controller
public class MyController {
    @Autowired
    private PostService postService;



    @GetMapping("/home")
    public String home(Model model) {
        
        List<Post> post = postService.findAll();
        // Post post = optionalPost.get();
        model.addAttribute("posts", post);
        System.out.println();
        System.out.println(post);
        return "home";

    }

    @GetMapping("/")
    public String homeWithPages(Model model, @RequestParam(required = false, name = "sort_by", defaultValue = "createdAt") String sort_by,
    @RequestParam(required = false, name="per_page", defaultValue = "2") String per_page,
    @RequestParam(required = false, name="page", defaultValue = "1") String page){

        Page<Post> posts_on_page = postService.findAll(Integer.parseInt(page)-1,Integer.parseInt(per_page), sort_by);
        int total_pages = posts_on_page.getTotalPages();
        List<Integer> pages = new ArrayList<>();
        if (total_pages > 0){
            pages = IntStream.rangeClosed(0, total_pages-1)
            .boxed().collect(Collectors.toList());
        }
        List<String> links = new ArrayList<>();

        if(pages != null){
            for (int link: pages){
                String active = "";
                if(link == posts_on_page.getNumber()){
                    active = "active";
                }
                String _temp_link = "/?per_page="+per_page+"&page="+(link+1)+"&sort_by="+sort_by;
                links.add("<li class=\"page-item "+active+"\"><a href=\""+_temp_link+"\" class='page-link'>"+(link+1)+"</a></li>");
            }
            model.addAttribute("links", links);
        }
        model.addAttribute("posts",posts_on_page);
        return "home";
    }   
    
}
