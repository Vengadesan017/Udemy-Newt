package com.vengat.FoodBySpringBoot.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vengat.FoodBySpringBoot.Services.AccountService;
import com.vengat.FoodBySpringBoot.Services.AuthorityService;
import com.vengat.FoodBySpringBoot.Services.PostService;
import com.vengat.FoodBySpringBoot.models.Account;
import com.vengat.FoodBySpringBoot.models.Authority;
import com.vengat.FoodBySpringBoot.models.Post;
// import com.vengat.FoodBySpringBoot.services.AccountService;
// import com.vengat.FoodBySpringBoot.services.AuthorityService;
// import com.vengat.FoodBySpringBoot.services.PostService;
// import com.vengat.FoodBySpringBoot.util.constants.Privillages;
// import com.vengat.FoodBySpringBoot.util.constants.Roles;
import com.vengat.FoodBySpringBoot.util.constants.Privillages;

@Component
public class SeedData implements CommandLineRunner{

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

       for(Privillages auth: Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);

       }
        
       Account account01 = new Account();
       Account account02 = new Account();
       Account account03 = new Account();
       Account account04 = new Account();

       account01.setEmail("user@user.com");
       account01.setPassword("pass987");
       account01.setFirstname("User");
       account01.setLastname("lastname");
       account01.setAge(25);
       account01.setDate_of_birth(LocalDate.parse("1990-01-01"));
       account01.setGender("Male");



       account02.setEmail("admin@studyeasy.org");
       account02.setPassword("pass987");
       account02.setFirstname("Admin");
       account02.setLastname("lastname");
       account04.setRole("User");
       account02.setAge(25);
       account02.setDate_of_birth(LocalDate.parse("1990-01-01"));
       account02.setGender("Famale");

       account03.setEmail("editor@editor.com");
       account03.setPassword("pass987");
       account03.setFirstname("Editor");
       account03.setLastname("lastname");
       account04.setRole("User");
       account03.setAge(55);
       account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
       account03.setGender("Male");

       account04.setEmail("super_editor@editor.com");
       account04.setPassword("pass987");
       account04.setFirstname("Editor");
       account04.setLastname("lastname");
      //  account04.setRole(Roles.EDITOR.getRole());
       account04.setRole("User");
       account04.setAge(40);
       account04.setDate_of_birth(LocalDate.parse("1980-01-01"));
       account04.setGender("Female");

       
       Set<Authority> authorities = new HashSet<>();
       authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
       authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
       account04.setAuthorities(authorities);

       accountService.save(account01);
       accountService.save(account02);
       accountService.save(account03);
       accountService.save(account04);
       


       List<Post> posts = postService.findAll();
       if (posts.size() == 0){
            Post post01 = new Post();
            post01.setTitle("About Git");
            post01.setBody("""
                  yuesrge
                  sldfbd
                  sdndb
            """);
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Spring Boot Model–view–controller framework");
            post02.setBody("""
                      
               <h1>Helloo Guys</h1>as
            """);
            
            post02.setAccount(account02);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("third post");
            post03.setBody("""
               <h1>Helloo Guys</h1>as
            """);
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("Fouth post");
            post04.setBody("""
                      
               <h1>Helloo Guys</h1>as
            """);
            
            post04.setAccount(account02);

            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("Fifth post");
            post05.setBody("""
               <h1>Helloo Guys</h1>as
            """);
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("Sixth post");
            post06.setBody("""
                      
               <h1>Helloo Guys</h1>as
            """);
            
            post06.setAccount(account02);
            postService.save(post06);

       }
        
    }
    
}
