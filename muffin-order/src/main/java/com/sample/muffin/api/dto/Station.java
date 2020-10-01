package com.sample.muffin.api.dto;

import lombok.Data;

@Data
public class Station{
	
	private Long Id;
	private String stationName;
	private String stationAddress;
	private String stationState="normal";
	
}
