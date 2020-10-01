package com.sample.muffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.OCB;
import com.sample.muffin.domain.repository.OCBRepository;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
public class Application {

	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
		
		OCBRepository ocbRepository = applicationContext.getBean(OCBRepository.class);
		
		OCB ocb1 = new OCB();
		
		ocb1.setMemberId((long)1);
		ocb1.setMemberName("최창우");
		ocb1.setOCBPoint(2000);
	
		ocbRepository.save(ocb1);
	}

}
