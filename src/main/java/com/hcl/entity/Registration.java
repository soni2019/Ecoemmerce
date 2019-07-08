package com.hcl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Size(max=20)
	@NotEmpty(message="Please provide UserName.")
	private String userName;
	private String phoneNo;
	
	@NotEmpty(message="Please provide UserType seller or buyer.")
	private String userType;
	
	@Email
	@NotEmpty(message="Please provide your email address.")
	private String email;
	
	@NotEmpty(message="Please provide contact address.")
	private String address;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", userName=" + userName + ", phoneNo=" + phoneNo + ", userType="
				+ userType + ", email=" + email + ", address=" + address + "]";
	}
	
	
	

}
