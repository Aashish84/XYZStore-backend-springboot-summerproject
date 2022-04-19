package com.asish.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asish.ecom.dao.CustomerDao;
import com.asish.ecom.entities.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerDao.findAll();
	}

	public List<Customer> getAllNewCustomer() {
		return (List<Customer>) customerDao.findByCompleteFalse();
	}

	public Customer addCustomer(Customer cus) {
		cus.setComplete(false);
		return customerDao.save(cus);
	}
}
