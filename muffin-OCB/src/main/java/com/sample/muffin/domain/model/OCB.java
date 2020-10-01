package com.sample.muffin.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class OCB extends AbstractEntity{
	
	private Long memberId;
	private String memberName;
	private int OCBPoint;
	
}
