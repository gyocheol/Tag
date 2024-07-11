package com.tag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)	// TODO : Spring Security 잠시 꺼두기 / login 개발 후 괄호 삭제!
@EnableJpaAuditing
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})	// mongoDB socket setting
public class TagApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application, application-db, application-login");
		SpringApplication.run(TagApplication.class, args);
	}
}
