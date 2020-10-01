package com.sample.muffin.domain.service;

import java.lang.reflect.Member;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.OCB;
import com.sample.muffin.domain.model.OrderPlaced;
import com.sample.muffin.domain.repository.OCBRepository;

@Service
public class OCBService {
	
	@Autowired
	OCBRepository ocbRepository;

	@StreamListener(KafkaProcessor.INPUT)
	public void onOrderPlaced(@Payload String message) {
		System.out.println("##### listener : " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		OrderPlaced orderPlaced = null;
		try {
			orderPlaced = objectMapper.readValue(message, OrderPlaced.class);

			if( orderPlaced.isMe()){
				System.out.println("OCBService : "+orderPlaced);
				
				Optional<OCB> memberOptional =  ocbRepository.findById(orderPlaced.getMemberId());
				OCB oCB = memberOptional.get();
				
				int point = oCB.getOCBPoint()+(int)(orderPlaced.getPrice()*0.1);
				
				oCB.setOCBPoint(point);
				ocbRepository.save(oCB);
				
			}


		}catch (Exception e){

		}
	}
	
	




}
