package com.asish.ecom.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asish.ecom.entities.Customer;
import com.asish.ecom.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class RestCustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer cus) {
		return customerService.addCustomer(cus); 
	}
}
