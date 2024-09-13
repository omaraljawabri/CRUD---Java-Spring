package com.firstcrud.omar.first_crud.requests;

import lombok.Data;

@Data
public class CustomerPostRequestBody {
	private String firstName;
	private String lastName;
	private String product;
}
