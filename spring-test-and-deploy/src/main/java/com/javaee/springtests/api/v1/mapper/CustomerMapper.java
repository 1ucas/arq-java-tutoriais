package com.javaee.springtests.api.v1.mapper;

import org.springframework.stereotype.Component;

import com.javaee.springtests.api.v1.model.CustomerDTO;
import com.javaee.springtests.domain.Customer;

@Component
public class CustomerMapper {

	public CustomerDTO customerToCustomerDTO(Customer customer) {
		final CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		return customerDTO;
	}

	public Customer customerDTOToCustomer(CustomerDTO custumerDTO) {
    	final Customer customer = new Customer();
    	customer.setFirstName(custumerDTO.getFirstName());
    	customer.setLastName(custumerDTO.getLastName());
		return customer;
    }
}
