package com.asish.ecom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asish.ecom.entities.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {

	public List<Category> findByNameLike(String name);

	public List<Category> findByStatus(boolean status);

	public List<Category> findAllByOrderByCreatedAtDesc();

	public List<Category> findAllByOrderByCreatedAtAsc();

	public List<Category> findAllByOrderByUpdatedAtDesc();

	public List<Category> findAllByOrderByUpdatedAtAsc();

	public List<Category> findByStatusOrderByCreatedAtDesc(boolean status);

	public List<Category> findByStatusOrderByCreatedAtAsc(boolean status);

	public List<Category> findByStatusOrderByUpdatedAtDesc(boolean status);

	public List<Category> findByStatusOrderByUpdatedAtAsc(boolean status);
}
