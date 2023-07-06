package com.example.commontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CommontestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommontestApplication.class, args);
	}

}
