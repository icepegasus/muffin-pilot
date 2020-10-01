package com.sample.muffin.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Member extends AbstractEntity{
	
	private String memberName;
	private String memberCarNo;
	private String memberState="Normal";
	
}
