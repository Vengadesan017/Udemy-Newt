package com.vengat.SpringBootJPA.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonRepo{

    @PersistenceContext
    EntityManager em;

    public Person findById(int id){
        return em.find(Person.class,1);
    }

    public Person create(Person person){
        return em.merge(person);
    }
}
