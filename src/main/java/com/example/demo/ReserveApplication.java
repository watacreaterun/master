package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.example.demo.controller", "com.example.demo.service"})
@EntityScan("com.example.demo.entity")
@ComponentScan(basePackages = {"com.example.demo", "com.example.demo.validator"})
@EnableJpaRepositories("com.example.demo.repository")
public class ReserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReserveApplication.class, args);
	}

}
