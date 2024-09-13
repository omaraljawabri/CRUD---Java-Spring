package com.firstcrud.omar.first_crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstcrud.omar.first_crud.domain.Customer;
import com.firstcrud.omar.first_crud.requests.CustomerPostRequestBody;
import com.firstcrud.omar.first_crud.requests.CustomerPutRequestBody;
import com.firstcrud.omar.first_crud.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody CustomerPostRequestBody customerPostRequestBody){
		return new ResponseEntity<>(customerService.save(customerPostRequestBody), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAll(){
		return ResponseEntity.ok(customerService.listAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable long id){
		return ResponseEntity.ok(customerService.findByIdOrThrowBadRequestException(id));
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody CustomerPutRequestBody customerPutRequestBody){
		customerService.replace(customerPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		customerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
