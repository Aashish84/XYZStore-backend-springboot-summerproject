package com.asish.ecom.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asish.ecom.entities.Category;
import com.asish.ecom.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class RestCategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory() {
		return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(categoryService.getCategoryById(id));
	}

	@PostMapping
	public ResponseEntity<Category> setCategory(@RequestBody Category c) throws Exception {
		Category addCategory = categoryService.addCategory(c);
		return new ResponseEntity<>(addCategory, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category c) throws Exception {
		return new ResponseEntity<>(categoryService.updateCategory(id, c), HttpStatus.ACCEPTED);
	}

}
