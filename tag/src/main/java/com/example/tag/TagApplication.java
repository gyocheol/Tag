package com.example.tag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})	// mongoDB socket setting
public class TagApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application, application-db, application-login");
		SpringApplication.run(TagApplication.class, args);
	}
}
