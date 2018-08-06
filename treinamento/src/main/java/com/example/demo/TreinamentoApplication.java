package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("domain.model")
@ComponentScan("domain.rest")
@EnableJpaRepositories("domain.repository")
public class TreinamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoApplication.class, args);
	}
}
