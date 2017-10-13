package com.subhadip.springboot.graphql.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.subhadip.springboot.graphql")
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
