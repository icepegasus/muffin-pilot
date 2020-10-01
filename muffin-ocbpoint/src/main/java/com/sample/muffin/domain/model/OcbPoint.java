package com.sample.muffin.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class OcbPoint extends AbstractEntity{
	
	private Long memberId;
	private String memberName;
	private int ocbPoint;
	
}
