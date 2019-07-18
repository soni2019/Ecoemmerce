package com.hcl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
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
	
	Registration reg;
	
	@Before
	public void setUp() throws Exception {
		reg = new Registration();
		reg.setUserId(123L);
		reg.setUserName("soni");
		reg.setUserType("seller");
		reg.setEmail("anc@gmkg.go");
		reg.setPhoneNo("4614");
		reg.setAddress("Banglore");
	}
	
	
	@Test
	public void testCreateUser() {
		Mockito.when(userServiceRepo.save(reg)).thenReturn(reg);
		RegistrationDto expectedValue= userServiceImpl.user(reg);
		assertEquals(expectedValue.getUserName(), reg.getUserName());
	}

	@Test
	public void testupdateUser() {	
		Registration newUser = new Registration();
		newUser.setUserId(123L);
		newUser.setUserName("singh");
		newUser.setUserType("buyer");
		
		Mockito.when(userServiceRepo.save(reg)).thenReturn(reg);
		Mockito.when(userServiceRepo.getOne(Mockito.anyLong())).thenReturn(reg);
		RegistrationDto expectedValue= userServiceImpl.updateUser(newUser, 123L);
		assertEquals(expectedValue.getUserType(), newUser.getUserType());
	}
	
	@Test
	public void testDeleteUser() {
		Mockito.when(userServiceRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(reg));
		String expectedValue= userServiceImpl.deleteUser(reg.getUserId());
		assertEquals("Deleted Sucessfully", expectedValue);
		
	}
}
