package com.cash.omni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OmniApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmniApplication.class, args);
	}

}
