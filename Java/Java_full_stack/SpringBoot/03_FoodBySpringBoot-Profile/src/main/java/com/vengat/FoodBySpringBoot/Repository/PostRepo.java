package com.vengat.FoodBySpringBoot.Repository;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vengat.FoodBySpringBoot.models.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    
}
