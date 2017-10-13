package com.subhadip.springboot.graphql.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.subhadip.springboot.graphql")
@EnableJpaRepositories("com.subhadip.springboot.graphql.repository")
@EntityScan("com.subhadip.springboot.graphql.model")
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
