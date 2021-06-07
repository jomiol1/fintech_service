package com.fintech.service.rest.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.service.constant.StatusCode;
import com.fintech.service.model.entity.CreditCardEntity;
import com.fintech.service.model.entity.PersonEntity;
import com.fintech.service.model.repository.CreditCardRepository;
import com.fintech.service.model.repository.PersonRepository;
import com.fintech.service.rest.dto.GenericResponse;
import com.fintech.service.rest.dto.PersonRequest;
import com.fintech.service.rest.dto.PersonResponse;
import com.fintech.service.rest.model.CreditCard;
import com.fintech.service.rest.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	public GenericResponse<PersonResponse> findById(Long id) {
		Optional<PersonEntity> optionalPerson = personRepository.findById(id);
		
        GenericResponse<PersonResponse> response = new GenericResponse<>();
		
		if(! optionalPerson.isPresent()) {
	         response.setStatusCode(StatusCode.NOT_FOUND.getCode());
	         response.setMessage(StatusCode.NOT_FOUND.getDescription());
			
		}else {
			PersonEntity personEntity = optionalPerson.get();
			CreditCardEntity creditCardEntity = personEntity.getCreditCardId();

	        response.setStatusCode(StatusCode.OK.getCode());
	        response.setMessage(StatusCode.OK.getDescription());
	        
	        response.setData(new PersonResponse(personEntity.getId(),personEntity.getName(),personEntity.getLastName(),
	        		personEntity.getGender(), new CreditCard(creditCardEntity.getNumber(), creditCardEntity.getCvv(),
	        				creditCardEntity.getYear(),creditCardEntity.getMonth())));
			
		}
		
		return response;
	}
	
	@Override
	public GenericResponse<List<PersonResponse>> getPersons() {
		
		List<PersonEntity> persons = personRepository.findByActiveIsTrue();
		
	    GenericResponse<List<PersonResponse>> response = new GenericResponse<>();
	    response.setStatusCode(StatusCode.OK.getCode());
	    response.setMessage(StatusCode.OK.getDescription());
		
		if(!persons.isEmpty()) {
			List<PersonResponse> personResponse = new ArrayList<PersonResponse>();
			
			persons.forEach(item->{
				personResponse.add(new PersonResponse(item.getId(),item.getName(),item.getLastName(),
						item.getGender(), new CreditCard(item.getCreditCardId().getNumber(), item.getCreditCardId().getCvv(),
								item.getCreditCardId().getYear(),item.getCreditCardId().getMonth())));
			});
			
	        response.setData(personResponse);
		}
		
          
		return response;
	}

	@Override
	public GenericResponse<PersonResponse> create(PersonRequest request) {
		
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(request.getName());
		personEntity.setLastName(request.getLastName());
		personEntity.setGender(request.getGender());
		personEntity.setActive(true);
		personRepository.save(personEntity);
		
		CreditCardEntity creditCardEntity = new CreditCardEntity();
		creditCardEntity.setNumber(request.getCreditCard().getNumber());
		creditCardEntity.setCvv(request.getCreditCard().getCvv());
		creditCardEntity.setYear(request.getCreditCard().getYear());
		creditCardEntity.setMonth(request.getCreditCard().getMonth());
		creditCardEntity.setPersonId(personEntity);
		creditCardRepository.save(creditCardEntity);
		
		personEntity.setCreditCardId(creditCardEntity);
		personRepository.save(personEntity);
		
        GenericResponse<PersonResponse> response = new GenericResponse<>();
        response.setStatusCode(StatusCode.OK.getCode());
        response.setMessage(StatusCode.OK.getDescription());
        response.setData(new PersonResponse(personEntity.getId(),personEntity.getName(),personEntity.getLastName(),
        		personEntity.getGender(), new CreditCard(creditCardEntity.getNumber(), creditCardEntity.getCvv(),
        				creditCardEntity.getYear(),creditCardEntity.getMonth())));
        
		return response;
	}

	@Override
	public GenericResponse<PersonResponse> update(PersonRequest request, Long id) {
		
		Optional<PersonEntity> optionalPerson = personRepository.findById(id);
		
        GenericResponse<PersonResponse> response = new GenericResponse<>();
		
		if(! optionalPerson.isPresent()) {
	         response.setStatusCode(StatusCode.NOT_FOUND.getCode());
	         response.setMessage(StatusCode.NOT_FOUND.getDescription());
			
		}else {
			PersonEntity personEntity = optionalPerson.get();
			personEntity.setName(request.getName());
			personEntity.setLastName(request.getLastName());
			personEntity.setGender(request.getGender());
			personRepository.save(personEntity);
			
			CreditCardEntity creditCardEntity = personEntity.getCreditCardId();
			creditCardEntity.setNumber(request.getCreditCard().getNumber());
			creditCardEntity.setCvv(request.getCreditCard().getCvv());
			creditCardEntity.setYear(request.getCreditCard().getYear());
			creditCardEntity.setMonth(request.getCreditCard().getMonth());
			creditCardRepository.save(creditCardEntity);
			
	        response.setStatusCode(StatusCode.OK.getCode());
	        response.setMessage(StatusCode.OK.getDescription());
	        
	        response.setData(new PersonResponse(personEntity.getId(),personEntity.getName(),personEntity.getLastName(),
	        		personEntity.getGender(), new CreditCard(creditCardEntity.getNumber(), creditCardEntity.getCvv(),
	        				creditCardEntity.getYear(),creditCardEntity.getMonth())));
			
		}
		
		return response;
	}

	@Override
	public GenericResponse<Void> delete(Long id) {
		
		Optional<PersonEntity> optionalPerson = personRepository.findById(id);
		
        GenericResponse<Void> response = new GenericResponse<>();
		
		if(! optionalPerson.isPresent()) {
	         response.setStatusCode(StatusCode.NOT_FOUND.getCode());
	         response.setMessage(StatusCode.NOT_FOUND.getDescription());
			
		}else {
			PersonEntity personEntity = optionalPerson.get();
			personEntity.setActive(false);
			personRepository.save(personEntity);
			
	        response.setStatusCode(StatusCode.OK.getCode());
	        response.setMessage(StatusCode.OK.getDescription());
			
		}
		
		return response;
	}

}
