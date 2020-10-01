package com.sample.muffin.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.muffin.api.MemberClient;
import com.sample.muffin.api.StationClient;
import com.sample.muffin.api.dto.Member;
import com.sample.muffin.api.dto.Station;
import com.sample.muffin.config.KafkaProcessor;
import com.sample.muffin.domain.model.Order;
import com.sample.muffin.domain.model.OrderCancelled;
import com.sample.muffin.domain.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private MemberClient memberClient;
	
	@Autowired
	private StationClient stationClient;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public void placeOrder(Order order) {
		
		Member member = memberClient.findMember(order.getMemberId());
		Station station = stationClient.findStation(order.getStationId());
		
		System.out.println("fegin clinet member: "+member);
		System.out.println("fegin clinet station: "+station);
		orderRepository.save(order);
		
	}
	
	@StreamListener(KafkaProcessor.INPUT)
	public void onOrderPlaced(@Payload String message) {
		System.out.println("##### listener : " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			OrderCancelled orderCancelled = objectMapper.readValue(message, OrderCancelled.class);

			if( orderCancelled.isMe()){
				Optional<Order> orderOptional = orderRepository.findById(orderCancelled.getOrderId());
				Order order = orderOptional.get();
				order.setOrderState("OrderCancelled");
				orderRepository.save(order);
			}


		}catch (Exception e){

		}
	}
	
	

}
