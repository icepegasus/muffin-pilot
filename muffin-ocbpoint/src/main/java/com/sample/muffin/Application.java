package com.sample.muffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.OcbPoint;
import com.sample.muffin.domain.repository.OcbPointRepository;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableDiscoveryClient
public class Application {

	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
		
		OcbPointRepository ocbRepository = applicationContext.getBean(OcbPointRepository.class);
		
		OcbPoint ocbPoint1 = new OcbPoint();
		
		ocbPoint1.setMemberId((long)1);
		ocbPoint1.setMemberName("최창우");
		ocbPoint1.setOcbPoint(2000);
	
		ocbRepository.save(ocbPoint1);
	}

}
