package com.example.tag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing
public class TagApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application,application-db,application-login,application-aws");
		SpringApplication.run(TagApplication.class, args);
	}

	/**
	 * JVM 기본 시간대 설정
	 */
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}
}
