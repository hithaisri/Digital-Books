package com.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BooksAuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksAuthorApplication.class, args);
	}

}
