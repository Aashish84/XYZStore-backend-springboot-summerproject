package com.asish.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asish.ecom.entities.OrderedItem;

@Repository
public interface OrderedItemDao extends CrudRepository<OrderedItem, Integer> {

	@Query(value = "select * from ordered_item oi where oi.customer_id = ?", nativeQuery = true)
	public List<OrderedItem> findByCustomerId(int id);

	@Query(value = "SELECT product_id , count(product_id) FROM `ordered_item` GROUP BY product_id ORDER BY COUNT(product_id) DESC;", nativeQuery = true)
	public List<Object[]> findTopProduct();

	@Query(value = "select sum(quantity) from ordered_item WHERE product_id = ?", nativeQuery = true)
	public int findProductOrderQuantity(int id);

	@Query(value = "select sum(quantity) , COUNT(id) from ordered_item where product_id = ?;", nativeQuery = true)
	public List<Object[]> findProductOrderQuantityForBrand(int id);
}
