package com.coderbd.thymeleafmongodbboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.coderbd.thymeleafmongodbboot.repository")
public class ThymeleafmongodbbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafmongodbbootApplication.class, args);
	}
	public void run(){}
}
