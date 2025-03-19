package com.vengat.SpringBootJPA.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonsRepo {

    @PersistenceContext
    EntityManager em;

    public Persons findById(int id){
        return em.find(Persons.class,1);
    }

    public Persons create(Persons person){
        return em.merge(person);
    }
}
