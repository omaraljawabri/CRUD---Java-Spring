package com.firstcrud.omar.first_crud.requests;

import lombok.Data;

@Data
public class CustomerPutRequestBody {
	private String firstName;
	private String lastName;
	private String product;
	private Long id;
}
