package com.asish.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asish.ecom.entities.PriceTracker;

@Repository
public interface PriceTrackerDao extends CrudRepository<PriceTracker, Integer> {

	@Query(value = "select * from price_tracker where product_id = ?", nativeQuery = true)
	public List<PriceTracker> findByProduct(int id);

}
