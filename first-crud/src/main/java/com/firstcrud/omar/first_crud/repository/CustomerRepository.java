package com.firstcrud.omar.first_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstcrud.omar.first_crud.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
