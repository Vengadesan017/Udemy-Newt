package com.vengat.Springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
		Sample obj = context.getBean(Sample.class);
		obj.haii();

		ClassTwo obj2 = context.getBean(ClassTwo.class);
		obj2.checking();
//		System.out.println("Hello..");
	}
}
