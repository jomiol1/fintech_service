package com.fintech.service.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.service.rest.dto.GenericResponse;
import com.fintech.service.rest.dto.PersonRequest;
import com.fintech.service.rest.dto.PersonResponse;
import com.fintech.service.rest.service.PersonService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/person")
@Api(
        value = "/person",
        produces = "application/json")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<PersonResponse>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersons());
    }
    
    @GetMapping(
            path = "/findById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<PersonResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
    }
    
    @PostMapping(
            path = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<PersonResponse>> create(@RequestBody PersonRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.create(request));
    }
	
    @PutMapping(
            path = "/update/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<PersonResponse>> update(@RequestBody PersonRequest request, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.update(request, id));
    }
    
    @DeleteMapping(
            path = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.delete(id));
    }

}
