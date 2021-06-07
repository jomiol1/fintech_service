package com.fintech.service.rest.service;

import java.util.List;

import com.fintech.service.rest.dto.GenericResponse;
import com.fintech.service.rest.dto.PersonRequest;
import com.fintech.service.rest.dto.PersonResponse;

public interface PersonService {
	
    public GenericResponse<List<PersonResponse>> getPersons();
    
    public GenericResponse<PersonResponse> findById(Long id);
    
    public GenericResponse<PersonResponse> create(PersonRequest request);
    
    public GenericResponse<PersonResponse> update(PersonRequest request, Long id);
    
    public GenericResponse<Void> delete(Long id);

}
