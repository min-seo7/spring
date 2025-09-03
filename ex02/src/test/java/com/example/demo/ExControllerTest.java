package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ExControllerTest.class)   //테스트하는 클래스명 넣어주면 됨. 
public class ExControllerTest {

	@Autowired private MockMvc mvc;
	
	@Test 
	public void testList() throws Exception { 
		
//		UserVO userVO = new UserVO (); 
//		userVO.setName("마이콜");
//	    userVO.setAge(20);
//	   
//	    String jsonStr = new ObjectMapper().writeValueAsString(userVO); 
	 
	    String result = mvc.perform(MockMvcRequestBuilders 
	                      .get("/api/rest2") //테스트 할 주소
	                      .param("age", "1") 
	                      .param("name", "kim"))
	                      .andExpect(status().isOk()) 
	                      .andReturn().getResponse().getContentAsString(); 
	    System.out.println(result);
	  
      }
}