package com.sample.muffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.Member;
import com.sample.muffin.domain.repository.MemberRepository;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableDiscoveryClient
public class Application {

	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
		
		MemberRepository memberRepository = applicationContext.getBean(MemberRepository.class);
		
		Member member1 = new Member();
		
		member1.setMemberCarNo("14누7051");
		member1.setMemberName("최창우");
		
		memberRepository.save(member1);
		
		Member member2 = new Member();
		
		member2.setMemberCarNo("12가1234");
		member2.setMemberName("김민주");
		
		memberRepository.save(member2);
		
		
		
	}
	
	

}
