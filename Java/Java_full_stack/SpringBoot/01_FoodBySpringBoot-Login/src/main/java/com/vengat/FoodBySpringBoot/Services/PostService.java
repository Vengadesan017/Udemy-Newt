package com.vengat.FoodBySpringBoot.Services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vengat.FoodBySpringBoot.Repository.PostRepo;
import com.vengat.FoodBySpringBoot.models.Post;
import org.springframework.data.domain.Page;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public Optional<Post> getById(Long id){
        return postRepo.findById(id);
    }

    public List<Post> getAll(){
        return postRepo.findAll();

    }

    public List<Post> findAll(){
        return postRepo.findAll();
    }
    
    public void delete(Post post){
        postRepo.delete(post);
    }
    public Post save(Post post){
        if (post.getId() == null){
            post.setCreatedAt(LocalDateTime.now());
        }
        post.setUpdatedAt(LocalDateTime.now());
        return postRepo.save(post);
    }

}
