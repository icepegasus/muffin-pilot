package com.sample.muffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.sample.muffin.config.KafkaProcessor;

@SpringBootApplication
@EnableFeignClients
@EnableBinding(KafkaProcessor.class)
//@EnableDiscoveryClient
public class Application {
	
	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
	}

}
