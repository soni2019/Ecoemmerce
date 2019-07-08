package com.hcl.service;

import com.hcl.dto.RegistrationDto;
import com.hcl.entity.Registration;

public interface IUserService {
	
	public RegistrationDto user(Registration registration);
	
	public RegistrationDto updateUser(Registration registration, Long userId);
	
	public String deleteUser(Long userId);
	

}
