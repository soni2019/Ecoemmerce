package com.hcl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.RegistrationDto;
import com.hcl.entity.Registration;
import com.hcl.service.IUserService;

@RestController
@RequestMapping("/onlineshopping")
public class UserController {
	@Autowired
	IUserService userService;
	
	
	@PostMapping("/users")
	public ResponseEntity<RegistrationDto> user(@Valid @RequestBody Registration registration) {
		RegistrationDto reg=userService.user(registration);
		
		return new ResponseEntity<RegistrationDto>(reg,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<RegistrationDto> updateUser(@RequestBody Registration registration,@RequestParam(value = "userId", required=true) Long userId ){
		RegistrationDto updateUser= userService.updateUser(registration, userId);
		return new ResponseEntity<RegistrationDto>(updateUser,HttpStatus.OK);
		
	}

	@DeleteMapping("/users/{userId}")
	public String deleteUser(@RequestParam(value = "userId", required=true) Long userId ){
		userService.deleteUser(userId);
		return  "Deleted Sucessfully";

	}
}