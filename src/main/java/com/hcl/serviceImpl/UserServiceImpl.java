package com.hcl.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.dto.RegistrationDto;
import com.hcl.entity.Registration;
import com.hcl.exception.DataNotFoundException;
import com.hcl.repository.IUserServiceRepo;
import com.hcl.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserServiceRepo userRepo;
		
	
	public RegistrationDto user(@RequestBody Registration registration){
		Registration newUser = userRepo.save(registration);
		RegistrationDto regDto= new RegistrationDto();		
		BeanUtils.copyProperties(newUser, regDto);
		return regDto;
		}


	@Override
	public RegistrationDto updateUser(Registration registration, Long userId) {
		
		RegistrationDto regDto=	setUservalue(registration,userId);
		
		return regDto;
	}
	
	public RegistrationDto setUservalue(Registration registration,Long userId ) {
		//Optional<Registration> user=userRepo.findById(userId);
		Registration oldUser =userRepo.getOne(userId);
		if(oldUser!=null) {
		if(registration.getUserName()!=null) {
		oldUser.setUserName(registration.getUserName());
		}
		if(registration.getEmail()!=null) {
		oldUser.setEmail(registration.getEmail());
		oldUser.setPhoneNo(registration.getPhoneNo());
		}
		if(registration.getUserType()!=null) {
		oldUser.setUserType(registration.getUserType());
		}
		if(registration.getAddress()!=null) {
		oldUser.setAddress(registration.getAddress());
		}
	}
		else {
			throw new DataNotFoundException("No Record Avaliable");
		}
		Registration newUser=userRepo.save(oldUser);
		RegistrationDto regDto= new RegistrationDto();
		BeanUtils.copyProperties(newUser, regDto);
		return regDto;
	}


	@Override
	public String deleteUser(Long userId) {
		if(ObjectUtils.isEmpty(userRepo.findById(userId))) {
			throw new DataNotFoundException("No Record Avaliable");
		}
		else {
			userRepo.deleteById(userId);
		}
		return "Deleted Sucessfully";
	}



}
