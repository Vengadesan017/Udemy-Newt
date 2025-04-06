package com.vengat.FoodBySpringBoot.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vengat.FoodBySpringBoot.models.Authority;
import com.vengat.FoodBySpringBoot.Repository.AuthorityRepo;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepo authorityRepo;

    public Authority save(Authority authority){
        return authorityRepo.save(authority);

    }

    public Optional<Authority> findById(Long id){
        return authorityRepo.findById(id);
    }

}
