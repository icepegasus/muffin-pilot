package com.sample.muffin.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.Member;
import com.sample.muffin.domain.model.OrderPlaced;
import com.sample.muffin.domain.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository MemberRepository;

	@StreamListener(KafkaProcessor.INPUT)
	public void onOrderPlaced(@Payload String message) {
		System.out.println("##### listener : " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		OrderPlaced orderPlaced = null;
		try {
			orderPlaced = objectMapper.readValue(message, OrderPlaced.class);

			if( orderPlaced.isMe()){
				System.out.println("MemberService : "+orderPlaced);
				
				Optional<Member> memberOptional =  MemberRepository.findById(orderPlaced.getMemberId());
				Member member = memberOptional.get();
				
				member.setMemberState("Reserved");
				
				MemberRepository.save(member);
				
			}


		}catch (Exception e){

		}
	}
	
	




}
