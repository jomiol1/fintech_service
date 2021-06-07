package com.fintech.service.rest.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fintech.service.constant.StatusCode;
import com.fintech.service.rest.dto.GenericResponse;
import com.fintech.service.rest.dto.PersonRequest;
import com.fintech.service.rest.dto.PersonResponse;
import com.fintech.service.rest.model.CreditCard;
import com.fintech.service.rest.service.PersonService;
import com.fintech.service.util.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonService personService;
	
	private static final PersonRequest REQUEST = new PersonRequest("juan","Perez","M",
			new CreditCard("xxxxxx","xxx","xx","xx"));
	private static final PersonResponse RESPONSE = new PersonResponse(1L,"juan","Perez","M",
			new CreditCard("xxxxxx","xxx","xx","xx"));
	
	@Test 
	public void testGetAllOK() throws Exception {
		
		List<PersonResponse> persons = new ArrayList<>();
		persons.add(RESPONSE);
		
	     GenericResponse<List<PersonResponse>> response = new GenericResponse<>();
	     response.setStatusCode(StatusCode.OK.getCode());
	     response.setMessage(StatusCode.OK.getDescription()); 
	     response.setData(persons);
	     
	     Mockito.when(personService.getPersons()).thenReturn(response);
	     
	     mvc.perform(get("/person/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
	     .andExpect(jsonPath("statusCode").value(StatusCode.OK.getCode()));
	     
	}
	
	@Test 
	public void testFindByIdOK() throws Exception {
		
	     GenericResponse<PersonResponse> response = new GenericResponse<>();
	     response.setStatusCode(StatusCode.OK.getCode());
	     response.setMessage(StatusCode.OK.getDescription()); 
	     response.setData(RESPONSE);
	     
	     Mockito.when(personService.findById(1L)).thenReturn(response);
	     
	     mvc.perform(get("/person/findById/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
	     .andExpect(jsonPath("statusCode").value(StatusCode.OK.getCode()))
	     .andExpect(jsonPath("data.id").value(RESPONSE.getId()))
	     .andExpect(jsonPath("data.name").value(RESPONSE.getName()))
	     .andExpect(jsonPath("data.lastName").value(RESPONSE.getLastName()))
	     .andExpect(jsonPath("data.gender").value(RESPONSE.getGender()));
	     
	}
	
	@Test 
	public void testCreateOK() throws Exception {
		
	     GenericResponse<PersonResponse> response = new GenericResponse<>();
	     response.setStatusCode(StatusCode.OK.getCode());
	     response.setMessage(StatusCode.OK.getDescription()); 
	     response.setData(RESPONSE);
	     
	     Mockito.when(personService.create(REQUEST)).thenReturn(response);
	     
	     mvc.perform(post("/person/create").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	    		 .content(TestUtil.convertObjectToJsonBytes(REQUEST)))
	     .andExpect(status().isOk());
	     
	}
	
	@Test 
	public void testUpdateOK() throws Exception {
		
	     GenericResponse<PersonResponse> response = new GenericResponse<>();
	     response.setStatusCode(StatusCode.OK.getCode());
	     response.setMessage(StatusCode.OK.getDescription()); 
	     response.setData(RESPONSE);
	     
	     Mockito.when(personService.update(REQUEST, 1L)).thenReturn(response);
	     
	     mvc.perform(put("/person/update/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	    		 .content(TestUtil.convertObjectToJsonBytes(REQUEST)))
	     .andExpect(status().isOk());
	     
	}
	
	@Test 
	public void testDeleteOK() throws Exception {
		
	     GenericResponse<Void> response = new GenericResponse<>();
	     response.setStatusCode(StatusCode.OK.getCode());
	     response.setMessage(StatusCode.OK.getDescription()); 
	     
	     Mockito.when(personService.delete(1L)).thenReturn(response);
	     
	     mvc.perform(delete("/person/delete/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	    		 .content(TestUtil.convertObjectToJsonBytes(REQUEST)))
	     .andExpect(status().isOk());
	     
	}
}
