package com.bug.mynote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MynoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MynoteApplication.class, args);
	}

}
