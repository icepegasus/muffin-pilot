package com.sample.muffin.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.muffin.api.MemberClient;
import com.sample.muffin.api.StationClient;
import com.sample.muffin.api.dto.Member;
import com.sample.muffin.api.dto.Station;
import com.sample.muffin.domain.model.Order;
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

}
