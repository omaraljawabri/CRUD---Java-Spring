package com.firstcrud.omar.first_crud.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.firstcrud.omar.first_crud.domain.Customer;
import com.firstcrud.omar.first_crud.repository.CustomerRepository;
import com.firstcrud.omar.first_crud.requests.CustomerPostRequestBody;
import com.firstcrud.omar.first_crud.requests.CustomerPutRequestBody;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	public Customer save(CustomerPostRequestBody customerPostRequestBody){
		return customerRepository.save(Customer.builder()
				.firstName(customerPostRequestBody.getFirstName())
				.lastName(customerPostRequestBody.getLastName())
				.product(customerPostRequestBody.getProduct())
				.build());
	}
	
	public List<Customer> listAll(){
		return customerRepository.findAll();
	}
	
	public Customer findByIdOrThrowBadRequestException(long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found!"));
	}
	
	public void replace(CustomerPutRequestBody customerPutRequestBody) {
		Customer savedCustomer = findByIdOrThrowBadRequestException(customerPutRequestBody.getId());
		Customer customer = Customer.builder()
			.id(savedCustomer.getId())
			.firstName(customerPutRequestBody.getFirstName())
			.lastName(customerPutRequestBody.getLastName())
			.product(customerPutRequestBody.getProduct())
			.build();
		customerRepository.save(customer);
	}
	
	public void delete(long id) {
		customerRepository.delete(findByIdOrThrowBadRequestException(id));
	}
}
