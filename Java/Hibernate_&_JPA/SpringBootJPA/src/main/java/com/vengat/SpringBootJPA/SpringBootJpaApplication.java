package com.vengat.SpringBootJPA;

import com.vengat.SpringBootJPA.jpa.Person;
import com.vengat.SpringBootJPA.jpa.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

	Logger lg;
	@Autowired
	public PersonRepo repo;

	Person p = new Person("Ramesh");
	Person p1 = new Person(1,"Rameshhh");
	Person p2 = new Person("Sureash");
	Person p3 = new Person("kameash");
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("haii");
		System.out.println(repo.save(p));
		System.out.println(repo.save(p1));
		System.out.println(repo.save(p2));
		System.out.println(repo.save(p3));
		System.out.println(repo.findById(1));
		System.out.println(repo.findById(2));
		System.out.println(repo.findById(3));
		System.out.println(repo.findById(4));
		repo.deleteById(3);


	}
}
