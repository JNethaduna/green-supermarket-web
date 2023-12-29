package com.green.supermarketwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enable scheduled tasks
public class SupermarketWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketWebAppApplication.class, args);
	}

}
