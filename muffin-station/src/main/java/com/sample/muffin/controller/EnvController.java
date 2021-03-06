package com.sample.muffin.controller;

import java.net.InetAddress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/env")
public class EnvController {
	
	@GetMapping("/hostname")
	public String getHostName() {
		String hostname="";
		try {
			hostname= InetAddress.getLocalHost().getHostName();
		
		}catch(Exception e) {
		}
		return hostname;
	}

}
