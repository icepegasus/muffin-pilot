package com.sample.muffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.sample.muffin.domain.model.Station;
import com.sample.muffin.domain.repository.StationRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class MuffinStationApplication {

	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MuffinStationApplication.class, args);
		
		StationRepository stationRepository = applicationContext.getBean(StationRepository.class);
		
		Station station1 = new Station();
		
		station1.setStationAddress("경기도 용인시 기흥구");
		station1.setStationName("21세기주유소");
		
		stationRepository.save(station1);
		
	}
	
	
	

}
