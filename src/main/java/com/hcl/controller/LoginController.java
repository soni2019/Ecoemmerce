package com.hcl.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Login;
import com.hcl.repository.LoginRepo;

@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	LoginRepo loginRepo;
	
	@PostMapping("/login")
	public ResponseEntity<String> createLogin(@RequestHeader ("userName") String userName, @RequestHeader("password") String password){
		Login login =new Login();
		if(userName!=null && password!=null) {
			login.setUserName(userName);
			Base64.Encoder encoder = Base64.getEncoder();
			String str=encoder.encodeToString(password.getBytes());
			login.setPassword(str);
			loginRepo.save(login);
		}
		return new ResponseEntity<String>("Login success",HttpStatus.CREATED);
		
		
	}
}
