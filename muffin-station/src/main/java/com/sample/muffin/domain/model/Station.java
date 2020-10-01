package com.sample.muffin.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Station extends AbstractEntity{
	
	private String stationName;
	private String stationAddress;
	private String stationState="normal";
	
}
