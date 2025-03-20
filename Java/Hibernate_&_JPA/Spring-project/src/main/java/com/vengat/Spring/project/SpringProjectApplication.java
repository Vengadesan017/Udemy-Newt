package com.vengat.Spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.yaml.snakeyaml.introspector.BeanAccess;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
		System.out.println(context);

		Gaming1 gaming1 = context.getBean(Gaming1.class);
		GameRunner bean = context.getBean(GameRunner.class);

		bean.startGame();
	}

}
