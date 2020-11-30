package com.cognizant.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
public class LaundryMenuService1Application {

	public static void main(String[] args) {
		SpringApplication.run(LaundryMenuService1Application.class, args);
	}

}
