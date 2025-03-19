package com.vengat.SpringBootJPA;

import com.vengat.SpringBootJPA.jpa.Person;
import com.vengat.SpringBootJPA.jpa.PersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=SpringBootJpaApplication.class)
public class PersonRepoTest {


    @Autowired
    PersonRepo repo;

    @Test
    public void findById_test() {
        Person person = repo.findById(1);
        assertEquals("Rameshhh", person.getName());
    }

    @Test
    public void deleteById_test(){
        Person p1 = repo.findById(2);
        repo.deleteById(p1.getId());
        assertNull(repo.findById(1));

    }

}
