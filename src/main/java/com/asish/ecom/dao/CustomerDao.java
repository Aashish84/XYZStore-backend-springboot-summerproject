package com.asish.ecom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asish.ecom.entities.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

	List<Customer> findByCompleteTrue();

	List<Customer> findByCompleteFalse();

}
