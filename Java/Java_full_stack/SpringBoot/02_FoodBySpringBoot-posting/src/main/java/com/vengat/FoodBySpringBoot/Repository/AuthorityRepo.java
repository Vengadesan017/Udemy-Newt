package com.vengat.FoodBySpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vengat.FoodBySpringBoot.models.Authority;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long>{
    
}
