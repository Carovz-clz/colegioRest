package com.carol.colegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ColegioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColegioApplication.class, args);
	}

}
