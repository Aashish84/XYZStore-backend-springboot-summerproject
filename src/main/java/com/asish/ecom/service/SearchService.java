package com.asish.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asish.ecom.dao.ProductDao;
import com.asish.ecom.entities.Product;

@Service
public class SearchService {

	@Autowired
	private ProductDao productDao;

	public List<Product> searchItem(String searchKey) {
		return productDao.findByNameLike(searchKey + "%");
	}
}
