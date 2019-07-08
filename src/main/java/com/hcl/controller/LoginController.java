package com.hcl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Login;
import com.hcl.service.ILogin;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	ILogin iLogin;
	
	@PostMapping("/createlogin")
	public ResponseEntity<String> createLogin(@Valid @RequestBody Login login){
		iLogin.createLogin(login);
		return new ResponseEntity<String>("Success",HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestHeader ("userName") String userName, @RequestHeader("password") String password){
		iLogin.loginUser(userName, password);
		return new ResponseEntity<String>("Login success",HttpStatus.CREATED);
		
		
	}
}
