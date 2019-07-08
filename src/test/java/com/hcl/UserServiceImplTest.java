package com.hcl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.dto.RegistrationDto;
import com.hcl.entity.Registration;
import com.hcl.repository.IUserServiceRepo;
import com.hcl.serviceImpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	@Mock
	IUserServiceRepo userServiceRepo;
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testCreateUser() {
		Registration reg = new Registration();
		reg.setUserId(123);
		reg.setUserName("soni");
		reg.setUserType("seller");
		reg.setEmail("anc@gmkg.go");
		reg.setPhoneNo("4614");
		reg.setAddress("Banglore");
		Mockito.when(userServiceRepo.save(reg)).thenReturn(reg);
		RegistrationDto expectedValue= userServiceImpl.user(reg);
		assertEquals(expectedValue.getUserName(), reg.getUserName());
	}

	@Test
	public void testupdateUser() {
		Registration reg = new Registration();
		reg.setUserId(123l);
		reg.setUserName("soni");
		reg.setUserType("seller");
		reg.setEmail("anc@gmkg.go");
		reg.setPhoneNo("4614");
		reg.setAddress("Banglore");
		
		Registration newUser = new Registration();
		newUser.setUserId(123l);
		newUser.setUserName("singh");
		newUser.setUserType("buyer");
		
		Mockito.when(userServiceRepo.save(reg)).thenReturn(reg);
		Mockito.when(userServiceRepo.getOne(Mockito.anyLong())).thenReturn(reg);
		RegistrationDto expectedValue= userServiceImpl.updateUser(newUser, 123l);
		assertEquals(expectedValue.getUserType(), newUser.getUserType());
	}
	
	@Test
	public void testDeleteUser() {
		Registration reg = new Registration();
		reg.setUserId(123l);
		reg.setUserName("soni");
		reg.setUserType("seller");
		reg.setEmail("anc@gmkg.go");
		reg.setPhoneNo("4614");
		reg.setAddress("Banglore");
		Mockito.when(userServiceRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(reg));
		String expectedValue= userServiceImpl.deleteUser(reg.getUserId());
		assertEquals("Deleted Sucessfully", expectedValue);
		
	}
}
