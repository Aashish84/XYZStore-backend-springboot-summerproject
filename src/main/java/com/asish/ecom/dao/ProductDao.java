package com.asish.ecom.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asish.ecom.entities.Category;
import com.asish.ecom.entities.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

	@Query(value = "select * from Product p where p.image = ?1 Limit 1", nativeQuery = true)
	public Optional<Product> findByFirstImageName(String imageName);

	@Query(value = "select DISTINCT * from Product where status=true Limit 5", nativeQuery = true)
	public Iterable<Product> findMultipleWithLimit();

	@Query(value = "select DISTINCT brand from Product ", nativeQuery = true)
	public List<String> findDistintBrand();

	@Query(value = "select id from product where brand = ?", nativeQuery = true)
	public List<Integer> findProductIdFromBrand(String brandName);

	public List<Product> findByNameContaining(String searchTxt);

	public List<Product> findByNameLike(String searchTxt);

	public List<Product> findByCategory(Category c);

}
