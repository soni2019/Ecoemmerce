package com.hcl.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	
	@PostMapping("/login")
	public ResponseEntity<String> createLogin(){
		RestTemplate restTemplate=new RestTemplate();		
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      headers.add("userName", "Soni");
	      headers.add("password", "123soni");
	      HttpEntity <String> entity = new HttpEntity<>(headers);
	    		   /*Login login=new Login();
	    		   login.setUserName("soni");
	    		   login.setPassword("soni123"); */  		   
	    		   return restTemplate.postForEntity("http://localhost:8080/onlineshopping", entity, String.class);
		
		
	}
}
