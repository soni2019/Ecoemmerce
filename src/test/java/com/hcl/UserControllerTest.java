package com.hcl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controller.UserController;
import com.hcl.entity.Registration;
import com.hcl.serviceImpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	private MockMvc mockmvc;
	@Mock
	UserServiceImpl userServiceImpl;
	
	Registration reg;
	
	@Before
	public void setUp() throws Exception {
		mockmvc = MockMvcBuilders.standaloneSetup(userController).build();
		reg= new Registration();
		reg.setUserId(123L);
		reg.setUserName("soni");
		reg.setUserType("seller");
		reg.setEmail("anc@gmkg.go");
		reg.setPhoneNo("4614");
		reg.setAddress("Banglore");
	}
	
	@Test
	public void testUser() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/onlineshopping/users")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL)
				.content(asJsonString(reg)))
				.andExpect(status().is(201));

	}
	
	@Test
	public void testUpdateUser() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.put("/onlineshopping/users/{userId}", 123L)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(reg)))
				.andExpect(status().isOk());
				
	}

	@Test
	public void testDeleteUser() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.delete("/onlineshopping/users/{userId}", 123L)
				.contentType(MediaType.ALL)
				.accept(MediaType.ALL)
				.content(asJsonString(reg)))
				.andExpect(status().isOk());

		/*mockmvc.perform( MockMvcRequestBuilders.delete("/onlineshopping/users/{userId}", 1) )
        .andExpect(status().isOk());*/
	}

	
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
