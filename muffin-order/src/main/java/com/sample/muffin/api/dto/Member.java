package com.sample.muffin.api.dto;

import lombok.Data;


@Data
public class Member {
	private Long Id;
	private String memberName;
	private String memberCarNo;
	private String memberState="Normal";
	
}
