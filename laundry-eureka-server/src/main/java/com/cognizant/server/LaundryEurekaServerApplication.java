package com.cognizant.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LaundryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaundryEurekaServerApplication.class, args);
	}

}
