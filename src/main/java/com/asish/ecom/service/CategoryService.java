package com.asish.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asish.ecom.dao.CategoryDao;
import com.asish.ecom.entities.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	// get from database
	public List<Category> getAllCategory() {
		Iterable<Category> findAll = categoryDao.findAll();
		return (List<Category>) findAll;
	}

	public Category getCategoryById(int id) {
		return categoryDao.findById(id).get();
	}

	public List<Category> getCategoryWithFilter(String filter) {
		List<Category> tmp = null;

		switch (filter) {
		case "all":
			tmp = (List<Category>) categoryDao.findAll();
			break;
		case "active":
			tmp = categoryDao.findByStatus(true);
			break;
		case "notactive":
			tmp = categoryDao.findByStatus(false);
			break;
		case "create_desc":
			tmp = categoryDao.findAllByOrderByCreatedAtDesc();
			break;
		case "create_asc":
			tmp = categoryDao.findAllByOrderByCreatedAtAsc();
			break;
		case "active_create_desc":
			tmp = categoryDao.findByStatusOrderByCreatedAtDesc(true);
			break;
		case "notactive_create_desc":
			tmp = categoryDao.findByStatusOrderByCreatedAtDesc(false);
			break;
		case "active_create_asc":
			tmp = categoryDao.findByStatusOrderByCreatedAtAsc(true);
			break;
		case "notactive_create_asc":
			tmp = categoryDao.findByStatusOrderByCreatedAtAsc(false);
			break;
		case "update_desc":
			tmp = categoryDao.findAllByOrderByUpdatedAtDesc();
			break;
		case "update_asc":
			tmp = categoryDao.findAllByOrderByUpdatedAtAsc();
			break;
		case "active_update_desc":
			tmp = categoryDao.findByStatusOrderByUpdatedAtDesc(true);
			break;
		case "notactive_update_desc":
			tmp = categoryDao.findByStatusOrderByUpdatedAtDesc(false);
			break;
		case "active_update_asc":
			tmp = categoryDao.findByStatusOrderByUpdatedAtAsc(true);
			break;
		case "notactive_update_asc":
			tmp = categoryDao.findByStatusOrderByUpdatedAtAsc(false);
			break;
		default:
			tmp = null;
		}
		return tmp;
	}

	public Category getOneCategoryById(int id) {
		return categoryDao.findById(id).get();
	}

	public List<Category> getCategoryByName(String name) {
		return categoryDao.findByNameLike(name + "%");
	}

	// add into database
	public Category addCategory(Category c) throws Exception {
		if (c.getName().length() == 0 || c.getName() == null) {
			throw new Exception("category name not entered ");
		}
		return categoryDao.save(c);
	}

	// update in database
	public Category updateCategory(int id, Category c) throws Exception {
		Optional<Category> findById = categoryDao.findById(id);
		if (findById.isPresent()) {
			if (c.getId() != 0 && c.getId() == id) {
				c.setCreatedAt(findById.get().getCreatedAt());
				Category save = categoryDao.save(c);
				return save;
			} else {
				throw new Exception("body id and uri id not matched");
			}
		} else {
			throw new Exception("no value present in table for update");
		}
	}

	// delete in database
	public void deleteCategory(int id) throws Exception {
		Optional<Category> findById = categoryDao.findById(id);
		if (findById.isPresent()) {
			categoryDao.deleteById(id);
		} else {
			throw new Exception("category doesnot exist to delete");
		}
	}

}
