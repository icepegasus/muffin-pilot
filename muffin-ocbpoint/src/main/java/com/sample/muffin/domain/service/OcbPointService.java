package com.sample.muffin.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.OcbPoint;
import com.sample.muffin.domain.model.OrderCancelled;
import com.sample.muffin.domain.model.OrderPlaced;
import com.sample.muffin.domain.repository.OcbPointRepository;

@Service
public class OcbPointService {
	
	@Autowired
	OcbPointRepository ocbPointRepository;

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
				
				Optional<OcbPoint> memberOptional =  ocbPointRepository.findByMemberId(orderPlaced.getMemberId());
				OcbPoint ocbPoint = memberOptional.get();
				
				int point = ocbPoint.getOcbPoint()+(int)(orderPlaced.getPrice()*0.1);
				
				ocbPoint.setOcbPoint(point);
				
				System.out.println("ocbPoint Saved : "+ocbPoint);
				ocbPointRepository.save(ocbPoint);
				
			}
			
			/**
             * 주유예약 취소
             */
            if( orderPlaced.getEventType().equals(OrderCancelled.class.getSimpleName())){
                Optional<OcbPoint> ocbPointOptional = ocbPointRepository.findByMemberId(orderPlaced.getMemberId());
                OcbPoint ocbPoint = ocbPointOptional.get();
                
                int point = ocbPoint.getOcbPoint()-(int)(orderPlaced.getPrice()*0.1);
                
                ocbPoint.setOcbPoint(point);
                System.out.println("ocbPoint Denied : "+ocbPoint);
                ocbPointRepository.save(ocbPoint);
                
            }


		}catch (Exception e){

		}
	}
	
	




}
