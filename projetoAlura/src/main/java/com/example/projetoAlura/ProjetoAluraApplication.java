package com.example.projetoAlura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
class ProjetoAluraApplication {

	@GetMapping
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAluraApplication.class, args);
	}
}