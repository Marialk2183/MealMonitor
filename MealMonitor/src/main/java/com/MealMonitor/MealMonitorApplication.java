package com.MealMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
public class MealMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealMonitorApplication.class, args);
	}

}
