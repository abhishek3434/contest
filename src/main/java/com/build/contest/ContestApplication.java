package com.build.contest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ContestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContestApplication.class, args);
	}

}