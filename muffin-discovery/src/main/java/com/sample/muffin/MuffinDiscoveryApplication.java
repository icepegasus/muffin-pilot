package com.sample.muffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MuffinDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuffinDiscoveryApplication.class, args);
	}

}
