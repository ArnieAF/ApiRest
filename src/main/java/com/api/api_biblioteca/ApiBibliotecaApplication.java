package com.api.api_biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api.api_biblioteca")
public class ApiBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBibliotecaApplication.class, args);
	}

}
