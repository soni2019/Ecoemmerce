package com.hcl.service;

import com.hcl.entity.Login;

public interface ILogin {
	
	public String createLogin(Login login);

	public String loginUser(String userName, String password);

}
