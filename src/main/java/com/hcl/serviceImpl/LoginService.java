package com.hcl.serviceImpl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Login;
import com.hcl.exception.DataNotFoundException;
import com.hcl.repository.ILoginRepo;
import com.hcl.service.ILogin;
@Service
public class LoginService implements ILogin {
	@Autowired
	ILoginRepo loginRepo;
		
	
	@Override
	public String createLogin(Login login) {
		if(login.getUserName()!=null && login.getPassword()!=null) {
			login.setUserName(login.getUserName());
			Base64.Encoder encoder = Base64.getEncoder();
			String str=encoder.encodeToString(login.getPassword().getBytes());
			login.setPassword(str);
			loginRepo.save(login);
	}
		return "Created sucessfully";
	}



	@Override
	public String loginUser(String userName, String password) {
		Login value = loginRepo.findByUserName(userName);
		String str= "Login Sucess";
		 Base64.Decoder decoder = Base64.getUrlDecoder();  
	     String dStr = new String(decoder.decode(value.getPassword()));
		if(value.getUserName().equalsIgnoreCase(userName)&& dStr.equals(password)) {
		return str;	
		}
		else {
			throw new DataNotFoundException("No Record Avaliable");
		}
	}
}
