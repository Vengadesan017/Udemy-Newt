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
        return em.find(Person.class,id);
    }

    public Person save(Person person){
        em.flush();
        em.detach(person);
        if (person.getId() == null){
            em.persist(person);
        }
        else{
             em.merge(person);
        }
        return person;
    }

    public void deleteById(int id) {
        em.remove(findById(id));
    }
}
